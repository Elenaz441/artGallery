package com.example.artgallery.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

// Класс для работы с RabbitMQ
@Service("rabbitService")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RabbitService {

    ObjectMapper objectMapper;
    RabbitTemplate rabbitTemplate;

    // Отправка сообщений на другой сервер
    @SneakyThrows
    public void send(Object message) {

        MessageProperties messageProperties = new MessageProperties();

        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);

        Message msg = new Message(objectMapper.writeValueAsBytes(message), messageProperties);

        rabbitTemplate.send("test.queue", msg);
    }
}
