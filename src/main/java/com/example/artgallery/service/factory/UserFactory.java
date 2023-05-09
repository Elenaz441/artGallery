package com.example.artgallery.service.factory;

import com.example.artgallery.domain.dto.request.CreateUserRequest;
import com.example.artgallery.domain.dto.response.UserResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.domain.entity.context.UserContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserFactory {

    PasswordEncoder passwordEncoder;

    public UserResponse createResponse(User user) {
        List<UserResponse.ExhibitionInfo> exhibitionInfo = user.getExhibitions() == null ? null
                : user.getExhibitions().stream()
                .map(this::createExhibitionInfo).toList();
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                exhibitionInfo
        );
    }

    public UserContext createContextFrom(CreateUserRequest createUserRequest) {
        return new UserContext(
                createUserRequest.getUsername(),
                passwordEncoder.encode(createUserRequest.getPassword()),
                createUserRequest.getRole()
        );
    }

    private UserResponse.ExhibitionInfo createExhibitionInfo(Exhibition exhibition) {
        return new UserResponse.ExhibitionInfo(
                exhibition.getId(),
                exhibition.getTitle()
        );
    }
}
