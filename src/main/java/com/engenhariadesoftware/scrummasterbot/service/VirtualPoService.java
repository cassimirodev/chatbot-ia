package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VirtualPoService {

    private ChatClient chatClient;
    @Autowired
    LogStorageService logStorageService;

    public VirtualPoService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getVirtualPoResponse(String userInput) {

        final String VIRTUAL_PO_RESPONSE = """
                Você é um Product Owner (PO) virtual. Sua função é simular a interação com uma equipe de desenvolvimento. Seja exigente, peça por mais detalhes nos requisitos, esclareça dúvidas e valide as entregas com a equipe. Mantenha um tom profissional, mas direto, focado no valor do produto.
                """;
        String fullPrompt = VIRTUAL_PO_RESPONSE + "\nInteração user: " + userInput;

        try {
            String response = chatClient.prompt()
                    .user(fullPrompt)
                    .call()
                    .content();

            logStorageService.salvarLog(response, userInput, "virtual-po");
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
