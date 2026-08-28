package com.example.demo.services;

import java.util.List;

import com.example.demo.requests.UpdateScoreRequest;
import com.example.demo.responses.LeaderboardResponse;

// Defines operations related to player scores.
public interface ScoreService {

    /**
     * Updates a player's score for a game.
     *
     * @param gameId the game identifier
     * @param request contains the player name and points earned
     * @return updated player leaderboard information
     */
    LeaderboardResponse updateScore(
            Long gameId,
            UpdateScoreRequest request
    );

    /**
     * Gets the leaderboard for a game.
     *
     * @param gameId the game identifier
     * @return players sorted by score in descending order
     */
    List<LeaderboardResponse> getLeaderboard(Long gameId);
}