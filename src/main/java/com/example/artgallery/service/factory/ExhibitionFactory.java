package com.example.artgallery.service.factory;

import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.User;
import com.example.artgallery.domain.entity.context.ExhibitionContext;

import java.util.stream.Collectors;

public class ExhibitionFactory {

    public ExhibitionResponse createResponse(Exhibition exhibition) {
        return new ExhibitionResponse(
                exhibition.getId(),
                exhibition.getTitle(),
                exhibition.getDescription(),
                exhibition.getStartDate(),
                exhibition.getEndDate(),
                exhibition.getPrice(),
                exhibition.getCountPlaces(),
                exhibition.getAddress(),
                exhibition.getParticipants().stream()
                        .map(this::createUserInfo)
                        .collect(Collectors.toList()),
                exhibition.getPictures().stream()
                        .map(this::createPictureInfo)
                        .collect(Collectors.toList())
        );
    }

    public ExhibitionContext createContextFrom(CreateExhibitionRequest createExhibitionRequest) {
        return new ExhibitionContext(
                createExhibitionRequest.getTitle(),
                createExhibitionRequest.getDescription(),
                createExhibitionRequest.getStartDate(),
                createExhibitionRequest.getEndDate(),
                createExhibitionRequest.getPrice(),
                createExhibitionRequest.getCountPlaces(),
                createExhibitionRequest.getAddress()
        );
    }

    private ExhibitionResponse.PictureInfo createPictureInfo(Picture picture) {
        return new ExhibitionResponse.PictureInfo(
                picture.getId(),
                picture.getTitle(),
                picture.getArtist()
        );
    }

    private ExhibitionResponse.UserInfo createUserInfo(User user) {
        return new ExhibitionResponse.UserInfo(
                user.getId(),
                user.getUsername()
        );
    }
}
