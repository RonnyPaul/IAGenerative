package espe.edu.ec.IAGenerative.controller;

import espe.edu.ec.IAGenerative.dto.ProgresoDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.service.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progreso")
public class ProgresoController {
    @Autowired
    private ProgresoService progresoService;

    @PostMapping
    public ResponseDTO crearProgreso(@RequestBody ProgresoDTO dto) {
        return progresoService.crearProgreso(dto);
    }

    @GetMapping("/todos")
    public ResponseDTO listarProgresos() {
        return progresoService.listarProgresos();
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarProgresoPorId(@PathVariable Long id) {
        return progresoService.buscarID(id);
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarProgreso(@PathVariable Long id, @RequestBody ProgresoDTO dto) {
        return progresoService.actualizarProgreso(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarProgreso(@PathVariable Long id) {
        return progresoService.eliminarProgreso(id);
    }
}
