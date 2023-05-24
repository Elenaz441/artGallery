package com.example.artgallery.domain.dto.request;

import com.example.artgallery.adapter.web.validation.constraint.ArtistConstraint;
import com.example.artgallery.adapter.web.validation.constraint.DatePictureConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.Date;

// Класс для запроса создания картины
@Value
public class CreatePictureRequest {

    @NotBlank
    String title;

    @ArtistConstraint
    String artist;

    @DatePictureConstraint
    Date creationDate;
}
