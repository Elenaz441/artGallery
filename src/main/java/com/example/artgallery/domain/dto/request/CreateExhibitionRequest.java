package com.example.artgallery.domain.dto.request;

import com.example.artgallery.adapter.web.validation.constraint.DateExhibitionConstraint;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// Класс для запроса создания выставки
@Value
public class CreateExhibitionRequest {

    @NotBlank
    String title;

    String description;

    @DateExhibitionConstraint
    Date startDate;

    @DateExhibitionConstraint
    Date endDate;

    @Min(0)
    BigDecimal price;

    @Min(5)
    Long countPlaces;

    @NotBlank
    String address;

    List<Long> pictures;
}
