package com.example.artgallery.service.factory;

import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.domain.entity.context.ExhibitionContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

// Класс для обработки запросов, связанных с выставками
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExhibitionFactory {

    // Создания ответа для пользователя о выставке
    public ExhibitionResponse createResponse(Exhibition exhibition) {
        return new ExhibitionResponse(
                exhibition.getId(),
                exhibition.getTitle(),
                exhibition.getDescription(),
                exhibition.getStartDate(),
                exhibition.getEndDate(),
                exhibition.getPrice(),
                exhibition.getCountPlaces(),
                exhibition.getAddress(),
                exhibition.getParticipants().stream()
                        .map(this::createUserInfo)
                        .collect(Collectors.toList()),
                exhibition.getPictures().stream()
                        .map(this::createPictureInfo)
                        .collect(Collectors.toList())
        );
    }

    // Создание контекста выставки
    public ExhibitionContext createContextFrom(CreateExhibitionRequest createExhibitionRequest) {
        return new ExhibitionContext(
                createExhibitionRequest.getTitle(),
                createExhibitionRequest.getDescription(),
                createExhibitionRequest.getStartDate(),
                createExhibitionRequest.getEndDate(),
                createExhibitionRequest.getPrice(),
                createExhibitionRequest.getCountPlaces(),
                createExhibitionRequest.getAddress(),
                createExhibitionRequest.getPictures()
        );
    }

    // Создание информации о картине при созданиии ответа пользователю
    private ExhibitionResponse.PictureInfo createPictureInfo(Picture picture) {
        return new ExhibitionResponse.PictureInfo(
                picture.getId(),
                picture.getTitle(),
                picture.getArtist()
        );
    }

    // Создание информации о посетителях при созданиии ответа пользователю
    private ExhibitionResponse.UserInfo createUserInfo(User user) {
        return new ExhibitionResponse.UserInfo(
                user.getId(),
                user.getUsername()
        );
    }
}
