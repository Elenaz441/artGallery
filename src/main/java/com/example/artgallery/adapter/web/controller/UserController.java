package com.example.artgallery.adapter.web.controller;

import com.example.artgallery.adapter.repository.UserRepository;
import com.example.artgallery.adapter.web.annotation.ApiV1;
import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest userRequest) {
        return new ResponseEntity<>(userService.createNewUser(userRequest), HttpStatus.OK);
    }

    @PutMapping("/register-for-exhibition/{idExhibition}")
    public ResponseEntity<UserResponse> addExhibition(@CurrentSecurityContext(expression="authentication?.name") String username, @PathVariable Long idExhibition) {
        User user = userRepository.findByUsername(username);
        return new ResponseEntity<>(userService.addExhibition(user.getId(), idExhibition), HttpStatus.OK);
    }
}
