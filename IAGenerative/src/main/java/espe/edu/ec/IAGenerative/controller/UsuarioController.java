package espe.edu.ec.IAGenerative.controller;

import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.dto.UsuarioDTO;
import espe.edu.ec.IAGenerative.entity.Usuario;
import espe.edu.ec.IAGenerative.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseDTO crearUsuario(UsuarioDTO dto) {
        return usuarioService.crearUsuario(dto);
    }

    @GetMapping("/todos")
    public ResponseDTO listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.buscarID(id);
    }

    @PutMapping("/{id}")
    public ResponseDTO editarUsuario(@PathVariable Long id, UsuarioDTO dto){
        return usuarioService.actualizarUsuario(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarUsuario(@PathVariable Long id){
        return usuarioService.eliminarUsuario(id);
    }
}
