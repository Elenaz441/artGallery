package com.example.artgallery.config;

import com.example.artgallery.config.properties.MyCustomProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Класс для обработки собственных конфигов
@Configuration
@EnableConfigurationProperties(MyCustomProperties.class)
public class MyCustomConfig {
}
