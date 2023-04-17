package com.example.artgallery.domain.dto.response;

import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.User;
import lombok.Value;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Value
public class ExhibitionResponse {
    Long id;
    String title;
    String description;
    Date startDate;
    Date endDate;
    BigDecimal price;
    Integer places;
    List<UserInfo> participants;
    List<PictureInfo> pictures;

    @Value
    public static class UserInfo {
        Long id;
        String username;
    }

    @Value
    public static class PictureInfo {
        Long id;
        String title;
        String artist;
        Date creationDate;
    }
}
