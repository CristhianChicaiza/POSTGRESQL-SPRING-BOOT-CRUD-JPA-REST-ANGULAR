package crud.proyecto.crudpbf.repository;

import crud.proyecto.crudpbf.models.Pais;
import crud.proyecto.crudpbf.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
