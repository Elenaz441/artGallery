package com.example.artgallery.service.factory;

import com.example.artgallery.domain.dto.request.CreatePictureRequest;
import com.example.artgallery.domain.dto.response.PictureResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.context.PictureContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

// Класс для обработки запросов, связанных с картинами
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PictureFactory {

    // Создания ответа для пользователя о картине
    public PictureResponse createResponse(Picture picture) {
        return new PictureResponse(
                picture.getId(),
                picture.getTitle(),
                picture.getArtist(),
                picture.getCreationDate(),
                picture.getExhibitions().stream()
                        .map(this::createExhibitionInfo)
                        .collect(Collectors.toList())
        );
    }

    // Создание контекста картины
    public PictureContext createContextFrom(CreatePictureRequest createPictureRequest) {
        return new PictureContext(
                createPictureRequest.getTitle(),
                createPictureRequest.getArtist(),
                createPictureRequest.getCreationDate()
        );
    }

    // Создание информации о выставках, в которых картина присутствует, при созданиии ответа пользователю
    private PictureResponse.ExhibitionInfo createExhibitionInfo(Exhibition exhibition) {
        return new PictureResponse.ExhibitionInfo(
                exhibition.getId(),
                exhibition.getTitle()
        );
    }

}
