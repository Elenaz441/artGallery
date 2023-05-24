package com.example.artgallery.domain.entity.context;

import lombok.Value;

import java.util.Date;

// Контекст для сущности "Картины"
@Value
public class PictureContext {
    String title;

    String artist;

    Date creationDate;

}
