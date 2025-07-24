package espe.edu.ec.IAGenerative.service;

import espe.edu.ec.IAGenerative.dto.ProgresoDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.entity.Ninio;
import espe.edu.ec.IAGenerative.entity.Progreso;
import espe.edu.ec.IAGenerative.repository.NinioRepository;
import espe.edu.ec.IAGenerative.repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgresoService {
    @Autowired
    private ProgresoRepository progresoRepository;

    @Autowired
    private NinioRepository ninioRepository;

    // Crear nuevo progreso
    public ResponseDTO crearProgreso(ProgresoDTO dto) {
        Progreso progreso = new Progreso();

        progreso.setHabilidad(dto.getHabilidad());
        progreso.setProgreso(dto.getProgreso());
        progreso.setFecha_progre(dto.getFecha_progre());

        Ninio nino = ninioRepository.findById(dto.getNinoID())
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));

        progreso.setNino(nino);

        Progreso saveProgreso = progresoRepository.save(progreso);
        return new ResponseDTO("Progreso registrado exitosamente", saveProgreso);
    }

    // Buscar progreso por ID
    public ResponseDTO buscarID(Long id) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado"));
        return new ResponseDTO("Progreso encontrado exitosamente", progreso);
    }

    // Actualizar progreso
    public ResponseDTO actualizarProgreso(Long id, ProgresoDTO dto) {
        Progreso progreso = progresoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progreso no encontrado"));

        progreso.setHabilidad(dto.getHabilidad());
        progreso.setProgreso(dto.getProgreso());
        progreso.setFecha_progre(dto.getFecha_progre());

        Ninio nino = ninioRepository.findById(dto.getNinoID())
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));

        progreso.setNino(nino);

        return new ResponseDTO("Progreso actualizado exitosamente", progresoRepository.save(progreso));
    }

    // Eliminar progreso
    public ResponseDTO eliminarProgreso(Long id) {
        if (!progresoRepository.existsById(id)) {
            throw new RuntimeException("Progreso no encontrado");
        }
        progresoRepository.deleteById(id);
        return new ResponseDTO("Progreso eliminado exitosamente", id);
    }

    // Listar todos los progresos
    public ResponseDTO listarProgresos() {
        List<Progreso> progresos = progresoRepository.findAll();
        int total = progresos.size();
        return new ResponseDTO("Se encontraron " + total + " progresos.", progresos);
    }
}
