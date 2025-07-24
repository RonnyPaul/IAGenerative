package espe.edu.ec.IAGenerative.service;

import espe.edu.ec.IAGenerative.dto.NnioDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.entity.Ninio;
import espe.edu.ec.IAGenerative.entity.Usuario;
import espe.edu.ec.IAGenerative.repository.NinioRepository;
import espe.edu.ec.IAGenerative.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinioService {
    @Autowired
    private NinioRepository ninioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear nuevo niño
    public ResponseDTO crearNinio(NnioDTO dto) {
        Ninio ninio = new Ninio();

        ninio.setNombre_nino(dto.getNombre_nino());
        ninio.setFechaNac(dto.getFechaNac());

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioID())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ninio.setUsuario(usuario);

        Ninio savedNinio = ninioRepository.save(ninio);
        return new ResponseDTO("Niño registrado exitosamente", savedNinio);
    }

    // Buscar niño por ID
    public ResponseDTO buscarID(Long id) {
        Ninio ninio = ninioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));
        return new ResponseDTO("Niño encontrado exitosamente", ninio);
    }

    // Actualizar niño
    public ResponseDTO actualizarNinio(Long id, NnioDTO dto) {
        Ninio ninio = ninioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));

        ninio.setNombre_nino(dto.getNombre_nino());
        ninio.setFechaNac(dto.getFechaNac());

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioID())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ninio.setUsuario(usuario);

        return new ResponseDTO("Niño actualizado exitosamente", ninioRepository.save(ninio));
    }

    // Eliminar niño
    public ResponseDTO eliminarNinio(Long id) {
        if (!ninioRepository.existsById(id)) {
            throw new RuntimeException("Niño no encontrado");
        }
        ninioRepository.deleteById(id);
        return new ResponseDTO("Niño eliminado exitosamente", id);
    }

    // Listar todos los niños
    public ResponseDTO listarNinios() {
        List<Ninio> ninios = ninioRepository.findAll();
        int total = ninios.size();
        return new ResponseDTO("Se encontraron " + total + " niños.", ninios);
    }
}
