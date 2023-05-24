package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.ExhibitionContext;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// Сущности выставки
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exhibition")
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;

    String title;

    String description;

    Date startDate;

    Date endDate;

    BigDecimal price;

    Long countPlaces;

    String address;

    // Связь многие-ко-многим между сущностью пользователи
    @ManyToMany()
    @JoinTable(name = "user_exhibition",
            joinColumns = { @JoinColumn(name = "exhibition_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    List<User> participants;

    // Связь многие-ко-многим между сущностью картины
    @ManyToMany()
    @JoinTable(name = "picture_exhibition",
            joinColumns = { @JoinColumn(name = "exhibition_id") },
            inverseJoinColumns = { @JoinColumn(name = "picture_id") })
    List<Picture> pictures;

    // Получение новой выставки через контекст
    public static Exhibition createExhibitionFrom(ExhibitionContext context) {
        return Exhibition.builder()
                .title(context.getTitle())
                .description(context.getDescription())
                .startDate(context.getStartDate())
                .endDate(context.getEndDate())
                .price(context.getPrice())
                .countPlaces(context.getCountPlaces())
                .address(context.getAddress())
                .participants(new LinkedList<>())
                .pictures(new LinkedList<>())
                .build();
    }

    // Метод для добавления новой картины на выставку
    public void addPicture(Picture picture) {
        this.pictures.add(picture);
        picture.getExhibitions().add(this);
    }
}
