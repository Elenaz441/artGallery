package com.example.artgallery.service.impl;

import com.example.artgallery.adapter.repository.UserRepository;
import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.domain.entity.context.UserContext;
import com.example.artgallery.service.UserService;
import com.example.artgallery.service.factory.UserFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserFactory userFactory;
    UserRepository userRepository;

    @Override
    public UserResponse createNewUser(CreateUserRequest userRequest) {
        UserContext context = userFactory.createContextFrom(userRequest);
        User user = User.createUserFrom(context);
        user = userRepository.save(user);
        return userFactory.createResponse(user);
    }
}
