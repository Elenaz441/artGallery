package com.example.artgallery.adapter.web.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// Аннотация для запросов для ADMIN-ов
@Documented
@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/admin/v1", produces = APPLICATION_JSON_VALUE)
public @interface AdminApiV1 {
}
