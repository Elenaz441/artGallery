package com.example.artgallery.adapter.listener;

import com.example.artgallery.domain.event.NewUserCreated;
import com.example.artgallery.common.exception.BadRequestException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

import java.sql.ResultSet;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewUserCreatedListener {
    DataSource dataSource;
    @EventListener
    @SneakyThrows
    public void handleNewUserCreatedEvent(NewUserCreated event) {
        ResultSet user = dataSource
                .getConnection()
                .createStatement()
                .executeQuery(String.format("select * from public.user where USERNAME='%s'", event.getUsername()));
        if (user.next()){
            throw new BadRequestException(String.format("User with username \"%s\" already exists", event.getUsername()));
        }
    }
}
