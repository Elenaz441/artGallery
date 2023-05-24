package com.example.artgallery.config;

import com.example.artgallery.config.properties.MyCustomProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Log4j2
@Configuration
public class TestConfig {

    @Autowired
    MyCustomProperties myCustomProperties;

    // Активируется, когда активен профиль "test"
    // Выводит в лог сообщение о конфиге
    @Bean
    @Profile(value = "test")
    public String testBean() {
        log.info("The server is running in {} mode with name {}",
                myCustomProperties.getMyEnv(),
                myCustomProperties.getMyApp());
        return "test";
    }

    // Активируется, когда активен профиль "dev"
    // Выводит в лог сообщение о конфиге
    @Bean
    @Profile(value = "dev")
    public String devBean() {
        log.info("The server is running in {} mode with name {}",
                myCustomProperties.getMyEnv(),
                myCustomProperties.getMyApp());
        return "dev";
    }
}