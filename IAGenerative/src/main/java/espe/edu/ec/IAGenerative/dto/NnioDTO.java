package espe.edu.ec.IAGenerative.dto;

import espe.edu.ec.IAGenerative.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NnioDTO {
    private Long id_ni;
    private String nombre_nino;
    private LocalDate fechaNac;
    private Long usuarioID;
}
