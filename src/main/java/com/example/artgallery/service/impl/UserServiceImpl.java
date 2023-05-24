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

// Класс для работы с данными из бд для сущности пользователи
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserFactory userFactory;
    UserRepository userRepository;
    ExhibitionRepository exhibitionRepository;

    // Создание всех пользователей
    @Override
    public UserResponse createNewUser(CreateUserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()) != null) {
            throw new BadRequestException(String.format("User with username \"%s\" already exists", userRequest.getUsername()));
        }
        UserContext context = userFactory.createContextFrom(userRequest);
        User user = new User(context);
        user = userRepository.save(user);
        return userFactory.createResponse(user);
    }

    // Регистрирование пользователя на выставку
    @Override
    public UserResponse addExhibition(String username, Long idExhibition) {
        User user = userRepository.findByUsername(username);
        List<Long> exhibitions = user
                .getExhibitions()
                .stream()
                .map(Exhibition::getId).toList();
        if (exhibitions.contains(idExhibition)){
            throw new BadRequestException("You have already registered for this exhibition");
        }
        Exhibition exhibition = exhibitionRepository.getReferenceById(idExhibition);
        if (exhibition.getParticipants().size() >= exhibition.getCountPlaces()) {
            throw new BadRequestException("Oops, sold out...");
        }
        user.addExhibition(exhibition);
        user = userRepository.save(user);
        return userFactory.createResponse(user);
    }
}
