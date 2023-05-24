package com.example.artgallery.service;

import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;

import java.util.List;

// Интерфейс для работы с данными из бд для сущности выставки
public interface ExhibitionService {
    ExhibitionResponse createNewExhibition(CreateExhibitionRequest exhibitionRequest);

    List<ExhibitionResponse> getExhibitions();

    void deletePastExhibitions();
}
