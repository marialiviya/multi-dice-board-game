package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.GameSession;

// Repository for game session database operations
public interface GameSessionRepository
        extends JpaRepository<GameSession, Long> {
}