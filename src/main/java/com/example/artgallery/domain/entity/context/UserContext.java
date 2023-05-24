package com.example.artgallery.domain.entity.context;

import lombok.Value;

// Контекст для сущности "Пользователи"
@Value
public class UserContext {
    String username;

    String password;

    String role;
}
