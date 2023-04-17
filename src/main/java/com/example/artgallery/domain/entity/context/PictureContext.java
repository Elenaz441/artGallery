package com.example.artgallery.domain.entity.context;

import lombok.Value;

import java.util.Date;

@Value
public class PictureContext {
    String title;

    String artist;

    Date creationDate;

}
