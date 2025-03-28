import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateService {
 private API_SERVER = "http://localhost:8080/state/";

  constructor(private  httpClient: HttpClient) {}

  public getAllstateByPais(idPais: any): Observable<any>{
    return this.httpClient.get(this.API_SERVER+idPais);
  }

}

