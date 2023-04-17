package com.example.artgallery.domain.dto.request;

import lombok.Value;

@Value
public class CreateUserRequest {
    String username;

    String password;

    String role;
}
