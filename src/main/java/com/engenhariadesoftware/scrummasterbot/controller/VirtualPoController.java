package com.engenhariadesoftware.scrummasterbot.controller;

import com.engenhariadesoftware.scrummasterbot.service.RestropectiveFacilitatorService;
import com.engenhariadesoftware.scrummasterbot.service.SprintPlanningService;
import com.engenhariadesoftware.scrummasterbot.service.VirtualPoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VirtualPoController {

    @Autowired
    private VirtualPoService virtualPoService;

    @GetMapping("/virtual-po")
    public ResponseEntity<String> retrospectiveFacilitator(@RequestParam String userInput) {
        try {
            String resposta = virtualPoService.getVirtualPoResponse(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
