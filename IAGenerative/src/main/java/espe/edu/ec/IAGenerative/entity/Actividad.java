package espe.edu.ec.IAGenerative.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion_act;
    private LocalDate fecha_act;

    //Relacion con las otras entidades
    @ManyToOne
    @JoinColumn(name = "id_ni")
    private Ninio ninio;
}
