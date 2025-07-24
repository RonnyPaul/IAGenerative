package espe.edu.ec.IAGenerative.service;

import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.dto.UsuarioDTO;
import espe.edu.ec.IAGenerative.entity.Usuario;
import espe.edu.ec.IAGenerative.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Crear nuevo autor
    public ResponseDTO crearUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario();

        usuario.setNombre_usu(dto.getNombre_usu());
        usuario.setCorreo_usu(dto.getCorreo_usu());
        usuario.setRol_usu(dto.getRol_usu());

        Usuario saveUsuario = usuarioRepository.save(usuario);
        return new ResponseDTO("Usuario registrado exitosamente", saveUsuario);
    }

    //buscar por id
    public ResponseDTO buscarID(Long id){

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Autor no encontrado"));
        return new ResponseDTO("Usuario encontrado exitosamente", usuario);
    }

    //Actualuzar
    public ResponseDTO actualizarUsuario(Long id, UsuarioDTO dto){

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Autor no encontrado"));
        usuario.setNombre_usu(dto.getNombre_usu());
        usuario.setCorreo_usu(dto.getCorreo_usu());
        usuario.setRol_usu(dto.getRol_usu());

        return new ResponseDTO("Usuario actualizado exitosamente",
                usuarioRepository.save(usuario));
    }

    //Eliminar
    public ResponseDTO eliminarUsuario(Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
        return new ResponseDTO("Usuario eliminado exitosamente", id);
    }

    //Listar todos los usuarios
    public ResponseDTO listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        int total = usuarios.size();
        return new ResponseDTO("Se encontraron " + total + " autores.", usuarios);
    }
}


