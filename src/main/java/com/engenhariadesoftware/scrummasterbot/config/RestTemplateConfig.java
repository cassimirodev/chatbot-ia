package com.engenhariadesoftware.scrummasterbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // As request estão demorarando mais de 30 segundos, então preciso definir um novo timeout
    // criando um Bean (componente) do RestTemplate, passando o timeout maior
    // posso apenas injetar no meu service onde eu precisar
    @Bean
    public RestTemplate restTemplate() {
        var factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(60000);
        factory.setReadTimeout(60000);
        return new RestTemplate(factory);
    }
}