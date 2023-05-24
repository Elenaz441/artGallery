package com.example.artgallery.domain.event;

import lombok.Value;

// Класс события создания нового пользователя
@Value
public class NewUserCreated {
    String username;

    public static NewUserCreated from(String username) {
        return new NewUserCreated(username);
    }
}
