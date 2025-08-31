package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SprintPlanningService {

    private ChatClient chatClient;
    @Autowired
    private RestTemplate restTemplate;

    public SprintPlanningService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    public String getSprintPlanningResponse(String userInput) {

        final String SPRINT_PLANNING_PROMPT = """
                                               Você é um assistente de Sprint Planning. Sua função é ajudar o time a estimar histórias de usuário em pontos (como no Planning Poker). Peça à equipe para listar suas user stories e, para cada uma, sugira uma estimativa de pontos (ex: 1, 2, 3, 5, 8, 13). Explique brevemente o raciocínio por trás da sua sugestão.
                                               """;
        String fullPrompt = SPRINT_PLANNING_PROMPT + "\nInteração do usuário: " + userInput;

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

