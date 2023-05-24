package com.example.artgallery.adapter.listener;

import com.example.artgallery.domain.event.NewUserCreated;
import com.example.artgallery.service.RabbitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NewUserCreatedListener {

    RabbitService rabbitService;

    //Метод, который отправляет сообщение на другой сервер после того, как был создан новый пользователь
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleNewAccountCreatedEvent(NewUserCreated event) {
        rabbitService.send(event);
    }
}
