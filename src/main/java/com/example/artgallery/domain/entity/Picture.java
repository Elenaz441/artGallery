package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.PictureContext;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

// Сущности картины
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;

    String title;

    String artist;

    Date creationDate;

    @ManyToMany(mappedBy = "pictures")
    @JsonIgnore
    List<Exhibition> exhibitions;

    // Получение новой картины через контекст
    public static Picture createPictureFrom(PictureContext context) {
        return Picture.builder()
                .title(context.getTitle())
                .artist(context.getArtist())
                .creationDate(context.getCreationDate())
                .exhibitions(new LinkedList<>())
                .build();
    }
}
