package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestropectiveFacilitatorService {

    private  ChatClient chatClient;
    @Autowired
    LogStorageService logStorageService;


    public RestropectiveFacilitatorService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getRestrospectiveFacilitatorResponse(String userInput) {

        final String RESTROSPECTIVE_FACILITATOR_PROMPT = """
                Você é um facilitador de retrospectivas. Ajude o time a processar feedbacks de uma sprint. Organize os pontos em categorias claras (Start, Stop, Continue) e, para cada categoria, sugira 1 a 2 planos de ação concretos e acionáveis.
                """;
        String fullPrompt = RESTROSPECTIVE_FACILITATOR_PROMPT + "\nInteração user: " + userInput;

        try {
            String response = chatClient.prompt()
                    .user(fullPrompt)
                    .call()
                    .content();

            logStorageService.salvarLog(response, userInput, "restrospective-facilitator");
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
