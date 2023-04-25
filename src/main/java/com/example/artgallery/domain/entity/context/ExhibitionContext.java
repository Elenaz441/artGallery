package com.example.artgallery.domain.entity.context;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Value
public class ExhibitionContext {
    String title;

    String description;

    Date startDate;

    Date endDate;

    BigDecimal price;

    Long countPlaces;

    String address;

//    TODO look how do here participants and pictures
}
