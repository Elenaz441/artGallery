package com.example.artgallery.domain.entity;

import com.example.artgallery.domain.entity.context.UserContext;
import com.example.artgallery.domain.event.NewUserCreated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// Сущности пользователя
// Также здесь регестрируется событей "Создание пользователя"
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

    @Column(unique = true)
    String username;

    String password;

    String role;

    Boolean enable;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    List<Exhibition> exhibitions;

    // Регистрация события и получение данных о новом пользователе
    public User(UserContext context) {
        registerEvent(() -> NewUserCreated.from(context.getUsername()));
        username = context.getUsername();
        password = context.getPassword();
        role = context.getRole();
        enable = true;
    }

    // Метод для регистрации пользователя на выставку
    public void addExhibition(Exhibition exhibition) {
        this.exhibitions.add(exhibition);
        exhibition.getParticipants().add(this);
    }

    // Список событий
    @Transient
    List<Supplier<Object>> events = new LinkedList<>();

    // Получение списка событий
    @DomainEvents
    protected List<Object> domainEvents() {
        return events.stream()
                .map(Supplier::get)
                .collect(Collectors.toUnmodifiableList());
    }

    // Очищение списка событий
    @AfterDomainEventPublication
    protected void afterDomainEventsPublication() {
        events.clear();
    }

    // Добавление нового события
    protected void registerEvent(Supplier<Object> event) {
        events.add(event);
    }
}
