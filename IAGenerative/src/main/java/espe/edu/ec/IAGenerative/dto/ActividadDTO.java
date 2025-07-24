package espe.edu.ec.IAGenerative.dto;

import espe.edu.ec.IAGenerative.entity.Ninio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {
    private Long idActDTO;
    private String descripcion_act;
    private LocalDate fecha_act;
    private Long idninio;
}
