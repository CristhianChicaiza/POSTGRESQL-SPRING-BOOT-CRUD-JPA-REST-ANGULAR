package crud.proyecto.crudpbf.repository;

import crud.proyecto.crudpbf.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
