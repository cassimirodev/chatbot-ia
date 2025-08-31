package com.engenhariadesoftware.scrummasterbot.controller;

import com.engenhariadesoftware.scrummasterbot.service.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScrumMasterController {

    @Autowired
    private ScrumMasterService scrumMasterService;

    @GetMapping("/scrum-master")
    public ResponseEntity<String> ScrumMaster(@RequestParam String userInput) {
        try {
            String resposta = scrumMasterService.getScrumMasterResponse(userInput);
            return ResponseEntity.status(200).body(resposta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar a requisição.");
        }
    }
}
