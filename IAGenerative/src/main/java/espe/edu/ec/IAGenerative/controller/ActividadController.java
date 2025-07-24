package espe.edu.ec.IAGenerative.controller;

import espe.edu.ec.IAGenerative.dto.ActividadDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @PostMapping
    public ResponseDTO crearActividad(@RequestBody ActividadDTO dto) {
        return actividadService.crearActividad(dto);
    }

    @GetMapping("/todos")
    public ResponseDTO listarActividades() {
        return actividadService.listarActividades();
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarActividadPorId(@PathVariable Long id) {
        return actividadService.buscarID(id);
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarActividad(@PathVariable Long id, @RequestBody ActividadDTO dto) {
        return actividadService.actualizarActividad(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarActividad(@PathVariable Long id) {
        return actividadService.eliminarActividad(id);
    }
}
