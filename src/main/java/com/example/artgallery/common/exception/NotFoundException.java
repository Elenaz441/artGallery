package com.example.artgallery.common.exception;

// Класс для ошибок типа 404
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
