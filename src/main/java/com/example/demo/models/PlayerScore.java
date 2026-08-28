package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Represents a player score
@Entity
@Table(name = "player_scores")
public class PlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = false)
    private int currentScore;

    // Game this player belongs to
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private GameSession game;

    // Default constructor
    public PlayerScore() {
    }

    // Constructor
    public PlayerScore(
            String playerName,
            int currentScore,
            GameSession game
    ) {
        this.playerName = playerName;
        this.currentScore = currentScore;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public GameSession getGame() {
        return game;
    }

    public void setGame(GameSession game) {
        this.game = game;
    }
}