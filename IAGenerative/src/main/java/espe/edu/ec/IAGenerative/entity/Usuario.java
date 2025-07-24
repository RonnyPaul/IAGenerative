package espe.edu.ec.IAGenerative.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_usu;

    private String nombre_usu;
    private String correo_usu;
    private String rol_usu;

    //Relacion con otra entidad: entidad ninio
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Ninio> ninos;
}
