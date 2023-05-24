package com.example.artgallery.domain.dto.response;

import lombok.Value;

import java.util.List;

// Класс для вывода информации о пользователе
@Value
public class UserResponse {
    Long id;
    String username;
    String password;
    String role;
    List<ExhibitionInfo> exhibitions;

    // Выставки, на которые он зарегестрирован
    @Value
    public static class ExhibitionInfo {
        Long id;
        String title;
    }
}
