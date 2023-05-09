package com.example.artgallery.service.impl;

import com.example.artgallery.adapter.repository.ExhibitionRepository;
import com.example.artgallery.adapter.repository.PictureRepository;
import com.example.artgallery.domain.dto.request.CreateExhibitionRequest;
import com.example.artgallery.domain.dto.response.ExhibitionResponse;
import com.example.artgallery.domain.entity.Exhibition;
import com.example.artgallery.domain.entity.Picture;
import com.example.artgallery.domain.entity.context.ExhibitionContext;
import com.example.artgallery.common.exception.NotFoundException;
import com.example.artgallery.service.ExhibitionService;
import com.example.artgallery.service.factory.ExhibitionFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExhibitionServiceImpl implements ExhibitionService {

    ExhibitionFactory exhibitionFactory;
    ExhibitionRepository exhibitionRepository;
    PictureRepository pictureRepository;

    @Override
    public ExhibitionResponse createNewExhibition(CreateExhibitionRequest exhibitionRequest) {
        ExhibitionContext context = exhibitionFactory.createContextFrom(exhibitionRequest);
        Exhibition exhibition = Exhibition.createExhibitionFrom(context);
        Exhibition finalExhibition = exhibition;
        exhibitionRequest.getPictures().forEach(id -> {
            Picture picture = pictureRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(
                    String.format("Not found picture with id %d", id)));
            finalExhibition.addPicture(picture);
        });
        exhibition = exhibitionRepository.save(finalExhibition);
        return exhibitionFactory.createResponse(exhibition);
    }

    @Override
    public List<ExhibitionResponse> getExhibitions() {
        return exhibitionRepository.findAll().stream()
                .map(exhibitionFactory::createResponse)
                .collect(Collectors.toList());
    }
}
