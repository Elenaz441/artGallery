package com.example.artgallery.service;

import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;

public interface UserService {
    UserResponse createNewUser(CreateUserRequest userRequest);

    UserResponse addExhibition(Long idUser, Long idExhibition);
}
