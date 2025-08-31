package com.engenhariadesoftware.scrummasterbot.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LogStorageService {

    public static final String LOG_PATH = "conversas.json";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void salvarLog(String response, String userInput, String endpoint) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File conversasJson = new File(LOG_PATH);

            List<Map<String, String>> logs = new ArrayList<>();
            if (conversasJson.exists() && conversasJson.length() > 0) {
                logs = mapper.readValue(conversasJson, mapper.getTypeFactory().constructCollectionType(List.class, Map.class));
            }


            Map<String, String> newLog = new HashMap<>();
            newLog.put("timestamp", java.time.LocalDateTime.now().format(FORMATTER));
            newLog.put("endpoint", endpoint);
            newLog.put("user_input", userInput);
            newLog.put("bot_response", response);

            logs.add(newLog);
            
            // deixa o output bonintho :)
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            mapper.writeValue(conversasJson, logs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}