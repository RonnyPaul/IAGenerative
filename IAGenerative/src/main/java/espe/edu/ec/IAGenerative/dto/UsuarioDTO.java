package espe.edu.ec.IAGenerative.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id_usu;
    private String nombre_usu;
    private String correo_usu;
    private String rol_usu;
}
