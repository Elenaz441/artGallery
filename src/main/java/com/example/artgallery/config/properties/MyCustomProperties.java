package com.example.artgallery.config.properties;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

// Класс для собственных конфигов
@Value
@ConstructorBinding
@ConfigurationProperties(MyCustomProperties.PREFIX)
public class MyCustomProperties {
    public static final String PREFIX = "my-config";

    String myEnv;
    String myApp;
}
