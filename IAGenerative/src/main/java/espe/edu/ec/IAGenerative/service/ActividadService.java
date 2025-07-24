package espe.edu.ec.IAGenerative.service;

import espe.edu.ec.IAGenerative.dto.ActividadDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.entity.Actividad;
import espe.edu.ec.IAGenerative.entity.Ninio;
import espe.edu.ec.IAGenerative.repository.ActividadRepository;
import espe.edu.ec.IAGenerative.repository.NinioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private NinioRepository ninioRepository;

    // Crear nueva actividad
    public ResponseDTO crearActividad(ActividadDTO dto) {
        Actividad actividad = new Actividad();

        actividad.setDescripcion_act(dto.getDescripcion_act());
        actividad.setFecha_act(dto.getFecha_act());

        Ninio ninio = ninioRepository.findById(dto.getIdninio())
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));

        actividad.setNinio(ninio);

        Actividad savedActividad = actividadRepository.save(actividad);
        return new ResponseDTO("Actividad registrada exitosamente", savedActividad);
    }

    // Buscar actividad por ID
    public ResponseDTO buscarID(Long id) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
        return new ResponseDTO("Actividad encontrada exitosamente", actividad);
    }

    // Actualizar actividad
    public ResponseDTO actualizarActividad(Long id, ActividadDTO dto) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));

        actividad.setDescripcion_act(dto.getDescripcion_act());
        actividad.setFecha_act(dto.getFecha_act());

        Ninio ninio = ninioRepository.findById(dto.getIdninio())
                .orElseThrow(() -> new RuntimeException("Niño no encontrado"));

        actividad.setNinio(ninio);

        return new ResponseDTO("Actividad actualizada exitosamente", actividadRepository.save(actividad));
    }

    // Eliminar actividad
    public ResponseDTO eliminarActividad(Long id) {
        if (!actividadRepository.existsById(id)) {
            throw new RuntimeException("Actividad no encontrada");
        }
        actividadRepository.deleteById(id);
        return new ResponseDTO("Actividad eliminada exitosamente", id);
    }

    // Listar todas las actividades
    public ResponseDTO listarActividades() {
        List<Actividad> actividades = actividadRepository.findAll();
        int total = actividades.size();
        return new ResponseDTO("Se encontraron " + total + " actividades.", actividades);
    }
}
