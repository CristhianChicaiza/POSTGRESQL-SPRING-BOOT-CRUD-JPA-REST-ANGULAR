import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  UntypedFormGroup,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { PersonService } from './service/person/person.service';
import { RouterModule, RouterOutlet } from '@angular/router';
import { PaisService } from './service/pais/pais.service';
import { StateService } from './service/state/state.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  personForm: UntypedFormGroup | any;
  paises: any[] = [];
  errorMessage: string | undefined;
  states: any[] = [];

  constructor(
    public fb: FormBuilder,
    public personService: PersonService,
    public stateService: StateService,
    public paisService: PaisService
  ) {}

  ngOnInit(): void {
    this.personForm = this.fb.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      age: ['', Validators.required],
      pais: ['', Validators.required],
      state: ['', Validators.required],
    });

    this.paisService.getAllpais().subscribe({
      next: (resp: any) => {
        this.paises = resp;
        // console.log(resp); no se realiza en un trabajo
        console.log(resp);
      },
      error: (error: any) => {
        this.errorMessage = 'Ocurrió un error al cargar los países';
        console.error(error);
      },
    });

    this.personForm.get('pais')?.valueChanges.subscribe({
      next: (value: any) => {
        console.log('País seleccionado:', value);

        if (value) {
          // Verificamos que 'value' tiene un 'id'
          this.stateService.getAllstateByPais(value).subscribe({
            next: (resp: any) => {
              this.states = resp;
              console.log('País seleccionado:', resp);
            },
            error: (error: any) => {
              this.errorMessage = 'Ocurrió un error al cargar ciudades';
              console.error(error);
            },
          });
        } else {
          this.states = []; // Si no hay país seleccionado, limpiar estados
        }
      },
      error: (error: any) => {
        console.error('Error en valueChanges:', error);
      },
    });
  }

  guardar(): void {
    this.personService.savePersona(this.personForm.value).subscribe({
      next: (resp) => {
        this.states = resp;
      },
      error: (error) => {
        console.error('Error al guardar datos:', error);
        console.log(this.personForm.value);
      },
    });
  }
}
