package crud.proyecto.crudpbf.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private  String age;
    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;
    @ManyToOne
    @JoinColumn (name="id_estado")
    private State state;


    public Persona() {
    }

    public Persona(long id, String name, String surname, String age, Pais pais, State state) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pais = pais;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public Pais getPais() {
        return pais;
    }

    public State getState() {
        return state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setState(State state) {
        this.state = state;
    }
}
