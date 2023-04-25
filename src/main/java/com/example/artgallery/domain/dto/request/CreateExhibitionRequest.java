package com.example.artgallery.domain.dto.request;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Value
public class CreateExhibitionRequest {
    String title;

    String description;

    Date startDate;

    Date endDate;

    BigDecimal price;

    Long countPlaces;

    String address;
}
