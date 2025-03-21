package crud.proyecto.crudpbf.rest;

import crud.proyecto.crudpbf.models.Pais;
import crud.proyecto.crudpbf.models.State;
import crud.proyecto.crudpbf.service.PaisService;
import crud.proyecto.crudpbf.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state/")
public class StateRest {

    @Autowired
    private StateService stateService;


    @GetMapping("{id}")
    private ResponseEntity<List<State>> getAllStatesByPais(@PathVariable ("id") long idPais) {
        return ResponseEntity.ok(stateService.findAllByCountry(idPais));
    }


}
