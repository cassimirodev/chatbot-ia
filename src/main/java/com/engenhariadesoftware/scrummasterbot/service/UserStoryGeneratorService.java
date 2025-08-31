package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserStoryGeneratorService {

    private ChatClient chatClient;
    @Autowired
    LogStorageService logStorageService;


    public UserStoryGeneratorService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getUserStoryResponse(String userInput) {

        final String USER_STORY_GENERATOR = """
                Você é um gerador de User Stories. Sua tarefa é transformar uma descrição de funcionalidade em uma User Story no formato "Como [persona], quero [funcionalidade], para [benefício]". Para cada história, sugira 2-3 critérios de aceitação detalhados. Se a descrição for muito curta, peça mais informações.
                """;
        String fullPrompt = USER_STORY_GENERATOR + "\nInteração user: " + userInput;

        try {
            String response = chatClient.prompt()
                    .user(fullPrompt)
                    .call()
                    .content();

            logStorageService.salvarLog(response, userInput, "user-story-generator");
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
