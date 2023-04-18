package com.example.artgallery.domain.dto.response;

import lombok.Value;

import java.util.List;

@Value
public class UserResponse {
    Long id;
    String username;
    String password;
    String role;
    List<ExhibitionInfo> exhibitions;

    @Value
    public static class ExhibitionInfo {
        Long id;
        String title;
    }
}
