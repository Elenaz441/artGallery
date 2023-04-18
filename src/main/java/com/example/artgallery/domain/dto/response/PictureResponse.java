package com.example.artgallery.domain.dto.response;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class PictureResponse {
    Long id;
    String title;
    String artist;
    Date creationDate;
    List<ExhibitionInfo> exhibitions;

    @Value
    public static class ExhibitionInfo {
        Long id;
        String title;
    }

}
