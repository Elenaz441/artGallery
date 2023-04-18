package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.ExhibitionContext;
import com.example.artgallery.domain.entity.context.UserContext;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String title;

    String description;

    Date startDate;

    Date endDate;

    BigDecimal price;

    Integer countPlaces;

    String address;

    @ManyToMany()
    @JoinTable(name = "exhibition_user",
            joinColumns = { @JoinColumn(name = "exhibition_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    List<User> participants;

    @ManyToMany()
    @JoinTable(name = "exhibition_picture",
            joinColumns = { @JoinColumn(name = "exhibition_id") },
            inverseJoinColumns = { @JoinColumn(name = "picture_id") })
    List<Picture> pictures;

    public static Exhibition createExhibitionFrom(ExhibitionContext context) {
        return Exhibition.builder()
                .title(context.getTitle())
                .description(context.getDescription())
                .startDate(context.getStartDate())
                .endDate(context.getEndDate())
                .participants(new LinkedList<>())
                .pictures(new LinkedList<>())
                .build();
    }
}
