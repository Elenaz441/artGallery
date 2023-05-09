package com.example.artgallery.adapter.web.advice;

import com.example.artgallery.adapter.web.annotation.ApiAdvice;
import com.example.artgallery.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@ApiAdvice
@RequiredArgsConstructor
public class BadRequestAdvice {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequest(Exception e) {

        return status(BAD_REQUEST)
                .body(e.getMessage());
    }
}
