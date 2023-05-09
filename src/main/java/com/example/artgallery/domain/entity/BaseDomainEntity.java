package com.example.artgallery.domain.entity;

import lombok.Getter;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
@MappedSuperclass
public abstract class BaseDomainEntity {

    @Transient
    List<Supplier<Object>> events = new LinkedList<>();

    @DomainEvents
    protected List<Object> domainEvents() {
        return events.stream()
                .map(Supplier::get)
                .collect(Collectors.toUnmodifiableList());
    }

    @AfterDomainEventPublication
    protected void afterDomainEventsPublication() {
        events.clear();
    }

    protected void registerEvent(Supplier<Object> event) {
        events.add(event);
    }
}
