package com.example.artgallery.service.impl;

import com.example.artgallery.adapter.repository.ExhibitionRepository;
import com.example.artgallery.adapter.repository.UserRepository;
import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.domain.entity.context.UserContext;
import com.example.artgallery.common.exception.BadRequestException;
import com.example.artgallery.service.UserService;
import com.example.artgallery.service.factory.UserFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserFactory userFactory;
    UserRepository userRepository;
    ExhibitionRepository exhibitionRepository;

    @Override
    public UserResponse createNewUser(CreateUserRequest userRequest) {
        UserContext context = userFactory.createContextFrom(userRequest);
        User user = new User(context);
        user = userRepository.save(user);
        return userFactory.createResponse(user);
    }

    @Override
    public UserResponse addExhibition(Long idUser, Long idExhibition) {
        User user = userRepository.getReferenceById(idUser);
        List<Long> exhibitions = user
                .getExhibitions()
                .stream()
                .map(Exhibition::getId).toList();
        if (exhibitions.contains(idExhibition)){
            throw new BadRequestException("You have already registered for this exhibition");
        }
        user.addExhibition(exhibitionRepository.getReferenceById(idExhibition));
        user = userRepository.save(user);
        return userFactory.createResponse(user);
    }
}
