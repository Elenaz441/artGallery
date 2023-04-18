package com.example.artgallery.service.factory;

import com.example.artgallery.domain.dto.request.CreatePictureRequest;
import com.example.artgallery.domain.dto.response.PictureResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.context.PictureContext;

import java.util.stream.Collectors;

public class PictureFactory {

    public PictureResponse createResponse(Picture picture) {
        return new PictureResponse(
                picture.getId(),
                picture.getTitle(),
                picture.getArtist(),
                picture.getCreationDate(),
                picture.getExhibitions().stream()
                        .map(this::createExhibitionInfo)
                        .collect(Collectors.toList())
        );
    }

    public PictureContext createPictureFrom(CreatePictureRequest createPictureRequest) {
        return new PictureContext(
                createPictureRequest.getTitle(),
                createPictureRequest.getArtist(),
                createPictureRequest.getCreationDate()
        );
    }

    private PictureResponse.ExhibitionInfo createExhibitionInfo(Exhibition exhibition) {
        return new PictureResponse.ExhibitionInfo(
                exhibition.getId(),
                exhibition.getTitle()
        );
    }

}
