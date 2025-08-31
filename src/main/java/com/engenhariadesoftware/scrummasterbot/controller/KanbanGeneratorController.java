package com.engenhariadesoftware.scrummasterbot.controller;


import com.engenhariadesoftware.scrummasterbot.service.BacklogPrioritizerService;
import com.engenhariadesoftware.scrummasterbot.service.KanbanGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KanbanGeneratorController {

    @Autowired
    private KanbanGeneratorService kanbanGeneratorService;

    @GetMapping("/kanban-generator")
    public ResponseEntity<String> kanbanGenerator(@RequestParam String userInput) {
        try {
            String resposta = kanbanGeneratorService.getKanbanGenerator(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
