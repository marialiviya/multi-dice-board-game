package com.example.demo.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Request for updating a player's score
public class UpdateScoreRequest {

    @NotBlank(message = "Player name is required")
    private String playerName;

    @NotNull(message = "Points are required")
    private Integer points;

    // Default constructor
    public UpdateScoreRequest() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}