package com.example.artgallery.domain.dto.response;

import lombok.Value;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// Класс для вывода информации для пользователя о выставке
@Value
public class ExhibitionResponse {
    Long id;
    String title;
    String description;
    Date startDate;
    Date endDate;
    BigDecimal price;
    Long countPlaces;
    String address;
    List<UserInfo> participants;
    List<PictureInfo> pictures;

    // Информация о зарегистрированных на выставку пользователях
    @Value
    public static class UserInfo {
        Long id;
        String username;
    }

    // Информация о картинах, которые будут на выставке
    @Value
    public static class PictureInfo {
        Long id;
        String title;
        String artist;
    }
}
