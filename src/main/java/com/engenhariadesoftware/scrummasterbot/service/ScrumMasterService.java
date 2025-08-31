package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScrumMasterService {

    private  ChatClient chatClient;
    @Autowired
    private RestTemplate restTemplate;

    public ScrumMasterService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getScrumMasterResponse(String userInput) {

        final String SCRUM_MASTER_PROMPT = """
                                               Você é um Scrum Master assistente.
                                               Sua função é guiar a equipe em um projeto ágil.
                                               Lembre o time sobre a Daily Scrum,
                                               pergunte sobre impedimentos ("O que te impede?")
                                               e sugira melhorias no processo de forma profissional e encorajadora.
                                               """;
        String fullPrompt = SCRUM_MASTER_PROMPT + "\nInteração da equipe: " + userInput;

        try {
            String response = chatClient.prompt()
                     .user(fullPrompt)
                     .call()
                     .content();
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
