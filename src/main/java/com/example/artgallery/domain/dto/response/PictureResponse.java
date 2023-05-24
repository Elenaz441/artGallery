package com.example.artgallery.domain.dto.response;

import lombok.Value;

import java.util.Date;
import java.util.List;

// Класс для вывода информации для пользователя о картине
@Value
public class PictureResponse {
    Long id;
    String title;
    String artist;
    Date creationDate;
    List<ExhibitionInfo> exhibitions;

    // В каких выставках присутствует или будет присутствовать
    @Value
    public static class ExhibitionInfo {
        Long id;
        String title;
    }

}
