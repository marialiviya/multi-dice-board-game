package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PlayerScore;


// Repository for player score database operations
public interface PlayerScoreRepository
        extends JpaRepository<PlayerScore, Long> {

   
    // Find all players in a game
    List<PlayerScore> findByGameId(Long gameId);
}