package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.UserContext;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;

    String username;

    String password;

    String role;

    Boolean enable;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    List<Exhibition> exhibitions;

    public static User createUserFrom(UserContext context) {
        return User.builder()
                .username(context.getUsername())
                .password(context.getPassword())
                .role(context.getRole())
                .enable(true)
                .exhibitions(new LinkedList<>())
                .build();
    }
}
