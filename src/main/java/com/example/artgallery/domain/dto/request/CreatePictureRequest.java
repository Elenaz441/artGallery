package com.example.artgallery.domain.dto.request;

import lombok.Value;

import java.util.Date;

@Value
public class CreatePictureRequest {
    String title;

    String artist;

    Date creationDate;
}
