package com.engenhariadesoftware.scrummasterbot.controller;



import com.engenhariadesoftware.scrummasterbot.service.ImpedimentDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImpedimentDetectoController {

    @Autowired
    private ImpedimentDetectorService impedimentDetectorService;


    @GetMapping("/impediment-detector")
    public ResponseEntity<String> ImpedimentDetector(@RequestParam String userInput) {
        try {
            String resposta = impedimentDetectorService.getImpedimentDetectorResponse(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
