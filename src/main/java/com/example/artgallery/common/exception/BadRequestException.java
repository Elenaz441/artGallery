package com.example.artgallery.common.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}
