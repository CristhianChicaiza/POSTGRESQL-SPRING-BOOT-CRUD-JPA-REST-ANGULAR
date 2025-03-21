package crud.proyecto.crudpbf.service;

import crud.proyecto.crudpbf.models.Pais;
import crud.proyecto.crudpbf.models.State;
import crud.proyecto.crudpbf.repository.PaisRepository;
import crud.proyecto.crudpbf.repository.StateRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Data
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }
    public List<State> findAllByCountry(long id) {
        List<State> stateRespuesta = new ArrayList<>();
        List<State> state = stateRepository.findAll();

        for (int i = 0; i < state.size(); i++) {
            if (state.get(i).getPais().getId() == id) {
                stateRespuesta.add(state.get(i));
            }
        }

        return stateRespuesta;
    }


}


