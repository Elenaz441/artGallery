package com.example.artgallery.common.exception;

// Класс для ошибок типа 401
public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}
