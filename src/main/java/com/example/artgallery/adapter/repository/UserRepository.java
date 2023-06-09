package com.example.artgallery.adapter.repository;

import com.example.artgallery.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для сущности Пользователи
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
