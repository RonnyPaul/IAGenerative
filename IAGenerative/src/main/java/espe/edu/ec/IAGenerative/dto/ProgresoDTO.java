package espe.edu.ec.IAGenerative.dto;

import espe.edu.ec.IAGenerative.entity.Ninio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgresoDTO {
    private Long id_progre;
    private String habilidad;
    private String progreso;
    private LocalDate fecha_progre;
    private Long ninoID;
}
