package espe.edu.ec.IAGenerative.controller;

import espe.edu.ec.IAGenerative.dto.NnioDTO;
import espe.edu.ec.IAGenerative.dto.ResponseDTO;
import espe.edu.ec.IAGenerative.service.NinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninio")
public class NinioController {
    @Autowired
    private NinioService ninioService;

    @PostMapping
    public ResponseDTO crearNinio(@RequestBody NnioDTO dto) {
        return ninioService.crearNinio(dto);
    }

    @GetMapping("/todos")
    public ResponseDTO listarNinios() {
        return ninioService.listarNinios();
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarNinioPorId(@PathVariable Long id) {
        return ninioService.buscarID(id);
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarNinio(@PathVariable Long id, @RequestBody NnioDTO dto) {
        return ninioService.actualizarNinio(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarNinio(@PathVariable Long id) {
        return ninioService.eliminarNinio(id);
    }
}
