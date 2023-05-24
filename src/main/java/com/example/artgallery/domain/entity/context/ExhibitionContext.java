package com.example.artgallery.domain.entity.context;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// Контекст для сущности "Выставки"
@Value
public class ExhibitionContext {
    String title;

    String description;

    Date startDate;

    Date endDate;

    BigDecimal price;

    Long countPlaces;

    String address;

    List<Long> pictures;
}
