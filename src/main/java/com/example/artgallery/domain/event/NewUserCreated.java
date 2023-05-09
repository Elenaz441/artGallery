package com.example.artgallery.domain.event;

import lombok.Value;

@Value
public class NewUserCreated {
    String username;

    public static NewUserCreated from(String username) {
        return new NewUserCreated(username);
    }
}
