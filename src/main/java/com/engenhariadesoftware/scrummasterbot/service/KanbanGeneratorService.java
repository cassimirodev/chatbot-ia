package com.engenhariadesoftware.scrummasterbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KanbanGeneratorService {

    @Autowired
    LogStorageService logStorageService;

    private  ChatClient chatClient;


    public KanbanGeneratorService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getKanbanGenerator(String userInput) {

        final String KANBAN_GENERATOR_PROMPT = """
                Você é um gerador de quadro Kanban. Sua tarefa é pegar uma lista de tarefas e organizá-las automaticamente em um quadro Kanban. Use as colunas 'A Fazer' (To Do), 'Em Progresso' (In Progress) e 'Feito' (Done). Para cada tarefa, atribua uma coluna e explique por que a categorizou assim.
                """;
        String fullPrompt = KANBAN_GENERATOR_PROMPT + "\nInteração user: " + userInput;

        try {
            String response = chatClient.prompt()
                    .user(fullPrompt)
                    .call()
                    .content();

            logStorageService.salvarLog(response, userInput, "kanban-generator");
            return response;
        } catch (Exception e) {
            System.out.println("ERRO!!!!");
            e.printStackTrace();
        }
        return "Desculpe, não foi possível solicitar a solicitação";
    }
}
