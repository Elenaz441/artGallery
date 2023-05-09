package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.UserContext;
import com.example.artgallery.domain.event.NewUserCreated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseDomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;

    @Column(unique = true)
    String username;

    String password;

    String role;

    Boolean enable;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    List<Exhibition> exhibitions;

    public User(UserContext context) {
        registerEvent(() -> NewUserCreated.from(context.getUsername()));
        username = context.getUsername();
        password = context.getPassword();
        role = context.getRole();
        enable = true;
    }

    public void addExhibition(Exhibition exhibition) {
        this.exhibitions.add(exhibition);
        exhibition.getParticipants().add(this);
    }
}
