package crud.proyecto.crudpbf.repository;

import crud.proyecto.crudpbf.models.Persona;
import crud.proyecto.crudpbf.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
