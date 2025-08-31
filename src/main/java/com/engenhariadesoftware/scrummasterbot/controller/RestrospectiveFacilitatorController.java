package com.engenhariadesoftware.scrummasterbot.controller;

import com.engenhariadesoftware.scrummasterbot.service.RestropectiveFacilitatorService;
import com.engenhariadesoftware.scrummasterbot.service.SprintPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestrospectiveFacilitatorController {

    @Autowired
    private RestropectiveFacilitatorService restropectiveFacilitatorService;

    @GetMapping("/retrospective-facilitator")
    public ResponseEntity<String> retrospectiveFacilitator(@RequestParam String userInput) {
        try {
            String resposta = restropectiveFacilitatorService.getRestrospectiveFacilitatorResponse(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
