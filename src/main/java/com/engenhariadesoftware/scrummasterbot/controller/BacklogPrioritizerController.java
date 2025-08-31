package com.engenhariadesoftware.scrummasterbot.controller;


import com.engenhariadesoftware.scrummasterbot.service.BacklogPrioritizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BacklogPrioritizerController {

    @Autowired
    private BacklogPrioritizerService backlogPrioritizerService;

    @GetMapping("/backlog-prioritizer")
    public ResponseEntity<String> backlogPrioritizer(@RequestParam String userInput) {
        try {
            String resposta = backlogPrioritizerService.getBacklogPrioritizer(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
