package com.example.demo.requests;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

// Request for creating a new game
public class CreateGameRequest {

    @NotBlank(message = "Game name is required")
    private String gameName;

    @NotEmpty(message = "At least one player is required")
    private List<@NotBlank(
            message = "Player name cannot be blank"
    ) String> players;

    // Default constructor
    public CreateGameRequest() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}