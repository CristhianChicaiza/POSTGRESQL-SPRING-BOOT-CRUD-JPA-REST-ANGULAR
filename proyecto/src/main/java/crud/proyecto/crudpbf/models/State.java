package crud.proyecto.crudpbf.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
