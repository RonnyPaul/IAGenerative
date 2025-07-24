package espe.edu.ec.IAGenerative.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Ninio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_ni;

    private String nombre_nino;
    private LocalDate  fechaNac;

    //Relacion con la entidad usuario
    @ManyToOne
    @JoinColumn(name = "id_usu")
    private Usuario usuario;

    //Relacion con entidad actividad
    @OneToMany(mappedBy = "ninio")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Actividad> actividad;

    //Relacion con Progreso
    @OneToMany(mappedBy = "nino")
    private List<Progreso> progresos;

}
