package com.example.artgallery.service;

import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;

// Интерфейс для работы с данными из бд для сущности пользователи
public interface UserService {
    UserResponse createNewUser(CreateUserRequest userRequest);

    UserResponse addExhibition(String username, Long idExhibition);
}
