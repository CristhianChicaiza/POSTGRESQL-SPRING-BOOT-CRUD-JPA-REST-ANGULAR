package crud.proyecto.crudpbf.service;

import crud.proyecto.crudpbf.models.Pais;
import crud.proyecto.crudpbf.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}
