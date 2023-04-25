package com.example.artgallery.domain.dto.request;

import com.example.artgallery.adapter.web.validation.ArtistConstraint;
import com.example.artgallery.adapter.web.validation.DatePictureConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Value
public class CreatePictureRequest {

    @NotBlank
    String title;

    @ArtistConstraint
    String artist;

    @DatePictureConstraint
    Date creationDate;
}
