package com.example.artgallery.adapter.web.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(basePackages = "com.example.artgallery.adapter.web")
public @interface ApiAdvice {
}
