package com.example.artgallery.adapter.repository;

import com.example.artgallery.domain.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для сущности Картины
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
