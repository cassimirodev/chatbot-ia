package com.engenhariadesoftware.scrummasterbot.controller;

import com.engenhariadesoftware.scrummasterbot.service.SprintPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SprintPlanningController {

    @Autowired
    private SprintPlanningService sprintPlanningService ;

    @GetMapping("/sprint-planning")
    public ResponseEntity<String> sprintPlanning(@RequestParam String userInput) {
        try {
            String resposta = sprintPlanningService.getSprintPlanningResponse(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
