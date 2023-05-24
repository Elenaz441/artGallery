package com.example.artgallery.common.aspect;

import com.example.artgallery.service.RabbitService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Аспект, который выводит в лог информацию о пользователе, который записался на выставку
@Log4j2
@Aspect
@Component
public class LogRequestsCountAspect {

    @Autowired
    RabbitService rabbitService;

    @AfterReturning("execution(* com.example.artgallery.adapter.web.controller.UserController.addExhibition(..))")
    public void getInfoAboutSignedUser(JoinPoint point) {
        log.info("User {} was signed up for the exhibition with id {}", point.getArgs()[0], point.getArgs()[1]);
    }
}
