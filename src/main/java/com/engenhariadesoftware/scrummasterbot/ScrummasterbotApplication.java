package com.engenhariadesoftware.scrummasterbot;

import com.engenhariadesoftware.scrummasterbot.service.ScrumMasterService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrummasterbotApplication  {

	public static void main(String[] args) {SpringApplication.run(ScrummasterbotApplication.class, args);}

}
