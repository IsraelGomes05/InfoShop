package com.sistnet.projeto.config;

import com.sistnet.projeto.services.DBService;
import com.sistnet.projeto.services.EmailService;
import com.sistnet.projeto.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;
    @Autowired
    private JavaMailSender sender;


    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateDataBase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
