package com.example.artgallery.adapter.web.controller;

import com.example.artgallery.adapter.web.annotation.AdminApiV1;
import com.example.artgallery.adapter.web.annotation.ApiV1;
import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;
import com.example.artgallery.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ExhibitionController {

    ExhibitionService exhibitionService;

    @GetMapping("/exhibitions")
    public ResponseEntity<List<ExhibitionResponse>> getExhibitions() {
        return new ResponseEntity<>(exhibitionService.getExhibitions(), HttpStatus.OK);
    }
}
