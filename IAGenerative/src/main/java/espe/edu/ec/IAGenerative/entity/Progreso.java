package espe.edu.ec.IAGenerative.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name= "progreso")
@Setter
@Getter
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_progre;

    private String habilidad;
    private String progreso;
    private LocalDate fecha_progre;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "progresos")
    private Ninio nino;
}
