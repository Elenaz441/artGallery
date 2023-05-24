package com.example.artgallery.domain.dto.request;

import lombok.Value;

// Класс для регистрации пользователей
@Value
public class CreateUserRequest {
    String username;

    String password;

    String role;
}
