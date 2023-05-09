package com.example.artgallery.adapter.web.controller;

import com.example.artgallery.adapter.web.annotation.AdminApiV1;
import com.example.artgallery.domain.dto.request.CreatePictureRequest;
import com.example.artgallery.domain.dto.response.PictureResponse;
import com.example.artgallery.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AdminPictureController {

    PictureService pictureService;

    @PostMapping("/picture")
    public ResponseEntity<PictureResponse> createPicture(@RequestBody @Valid CreatePictureRequest pictureRequest) {
        return new ResponseEntity<>(pictureService.createNewPicture(pictureRequest), HttpStatus.OK);
    }
}
