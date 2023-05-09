package com.example.artgallery.service;

import com.example.artgallery.domain.dto.request.CreatePictureRequest;
import com.example.artgallery.domain.dto.response.PictureResponse;

import java.util.List;

public interface PictureService {
    PictureResponse createNewPicture(CreatePictureRequest pictureRequest);

    List<PictureResponse> getPictures();
}
