package espe.edu.ec.IAGenerative.controller;

import espe.edu.ec.IAGenerative.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;

    @GetMapping("/prompt")
    public String pregunta(@RequestParam String prompt){

        return geminiService.preguntaGemini(prompt);
    }
}
