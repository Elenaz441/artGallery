package com.example.artgallery.domain.entity.context;

import lombok.Value;

@Value
public class UserContext {
    String username;

    String password;

    String role;
}
