package com.example.artgallery.service.impl;

import com.example.artgallery.adapter.repository.PictureRepository;
import com.example.artgallery.domain.dto.request.CreatePictureRequest;
import com.example.artgallery.domain.dto.response.PictureResponse;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.context.PictureContext;
import com.example.artgallery.service.PictureService;
import com.example.artgallery.service.factory.PictureFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Класс для работы с данными из бд для сущности картины
@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PictureServiceImpl implements PictureService {

    PictureFactory pictureFactory;
    PictureRepository pictureRepository;

    // Создание новой картины
    @Override
    public PictureResponse createNewPicture(CreatePictureRequest pictureRequest) {
        PictureContext context = pictureFactory.createContextFrom(pictureRequest);
        Picture picture = Picture.createPictureFrom(context);
        picture = pictureRepository.save(picture);
        return pictureFactory.createResponse(picture);
    }

    // Список всех картин
    @Override
    public List<PictureResponse> getPictures() {
        return pictureRepository.findAll().stream()
                .map(pictureFactory::createResponse)
                .collect(Collectors.toList());
    }
}
