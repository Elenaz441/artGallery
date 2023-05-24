package com.example.artgallery.adapter.web.controller;

import com.example.artgallery.adapter.web.annotation.AdminApiV1;
import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;
import com.example.artgallery.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

// Контроллер админа для сущности "Выставки"
@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AdminExhibitionController {

    ExhibitionService exhibitionService;

    // Метод создания выставки
    @PostMapping("/exhibition")
    public ResponseEntity<ExhibitionResponse> createExhibition(@RequestBody @Valid CreateExhibitionRequest exhibitionRequest) {
        return new ResponseEntity<>(exhibitionService.createNewExhibition(exhibitionRequest), HttpStatus.OK);
    }
}
