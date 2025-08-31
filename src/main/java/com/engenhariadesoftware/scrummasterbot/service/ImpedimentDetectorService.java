package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImpedimentDetectorService {

    private  ChatClient chatClient;
    @Autowired
    LogStorageService logStorageService;

    public ImpedimentDetectorService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getImpedimentDetectorResponse(String userInput) {

        final String IMPEDIMENT_DETECTOR_PROMPT = """
                Você é um detector de impedimentos. Receberá um relato de uma Daily Stand-up. Identifique padrões de problemas recorrentes, gargalos ou dependências problemáticas. Sua resposta deve listar os impedimentos detectados e sugerir o próximo passo para o Scrum Master.
                """;
        String fullPrompt = IMPEDIMENT_DETECTOR_PROMPT + "\nInteração user: " + userInput;

        try {
            String response = chatClient.prompt()
                    .user(fullPrompt)
                    .call()
                    .content();

            logStorageService.salvarLog(response, userInput, "impediment-detector");
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
