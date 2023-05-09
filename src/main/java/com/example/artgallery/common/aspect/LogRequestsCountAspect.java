package com.example.artgallery.common.aspect;

import com.example.artgallery.adapter.repository.ExhibitionRepository;
import com.example.artgallery.common.exception.BadRequestException;
import com.example.artgallery.domain.entity.Exhibition;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogRequestsCountAspect {
    @Autowired
    ExhibitionRepository exhibitionRepository;

    @Before("execution(* com.example.artgallery.adapter.web.controller.UserController.addExhibition(..))")
    public void countUsages(JoinPoint point) throws Exception {
        Exhibition exhibition = exhibitionRepository.getReferenceById((Long) point.getArgs()[1]);
        if (exhibition.getParticipants().size() >= exhibition.getCountPlaces()) {
            throw new BadRequestException("Oops, sold out...");
        }
    }
}
