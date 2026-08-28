package com.example.demo.responses;

import java.util.List;

import com.example.demo.models.GameStatus;

/**
 * Represents the response returned after creating a game.
 */
public class GameResponse {

private final Long id;
private final String gameName;
private final GameStatus status;
private final List<String> players;

    /**
     * Creates a game response.
     *
     * @param id game ID
     * @param gameName name of the game
     * @param status current game status
     * @param players players participating in the game
     */
    public GameResponse(
            Long id,
            String gameName,
            GameStatus status,
            List<String> players
    ) {
        this.id = id;
        this.gameName = gameName;
        this.status = status;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public GameStatus getStatus() {
        return status;
    }

    public List<String> getPlayers() {
        return players;
    }
}