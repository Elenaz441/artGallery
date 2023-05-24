package com.example.artgallery.adapter.web.advice;

import com.example.artgallery.adapter.web.annotation.ApiAdvice;
import com.example.artgallery.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

// Класс для обработки ошибок с кодом 404 (not found)
@ApiAdvice
@RequiredArgsConstructor
public class NotFoundAdvice {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> notFound(Exception e) {

        return status(NOT_FOUND)
                .body(e.getMessage());
    }
}