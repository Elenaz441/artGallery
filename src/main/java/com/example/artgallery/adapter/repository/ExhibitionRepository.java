package com.example.artgallery.adapter.repository;

import com.example.artgallery.domain.entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для сущности Выставки
@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
