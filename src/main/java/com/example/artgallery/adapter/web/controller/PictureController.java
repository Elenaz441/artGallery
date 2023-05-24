package com.example.artgallery.adapter.web.controller;

import com.example.artgallery.adapter.web.annotation.ApiV1;
import com.example.artgallery.domain.dto.response.PictureResponse;
import com.example.artgallery.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

// Контроллер пользователя для сущности "Картины"
@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PictureController {

    PictureService pictureService;

    // Метод получения всех картин
    @GetMapping("/pictures")
    public ResponseEntity<List<PictureResponse>> getPictures() {
        return new ResponseEntity<>(pictureService.getPictures(), HttpStatus.OK);
    }
}
