package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BacklogPrioritizerService {
    
    private  ChatClient chatClient;
    @Autowired
    private RestTemplate restTemplate;

    public BacklogPrioritizerService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getBacklogPrioritizer(String userInput) {

        final String USER_STORY_GENERATOR = """
                Você é um especialista em priorização de backlog. Receberá uma lista de funcionalidades com seus critérios de priorização (ex.: valor de negócio, esforço, risco). Ajude a organizar o backlog aplicando a técnica MoSCoW (Must, Should, Could, Won't). Peça os dados se não forem fornecidos.
                """;
        String fullPrompt = USER_STORY_GENERATOR + "\nInteração user: " + userInput;

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
