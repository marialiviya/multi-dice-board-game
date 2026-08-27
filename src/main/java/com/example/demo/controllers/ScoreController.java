package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requests.UpdateScoreRequest;
import com.example.demo.responses.LeaderboardResponse;
import com.example.demo.services.ScoreService;

import jakarta.validation.Valid;

// Controller for player score operations.
@RestController
@RequestMapping("/api/games")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    /**
     * Updates a player's score for a game.
     *
     * POST /api/games/{gameId}/turn
     */
    @PostMapping("/{gameId}/turn")
    public ResponseEntity<LeaderboardResponse> updateScore(
            @PathVariable Long gameId,
            @Valid @RequestBody UpdateScoreRequest request) {

        LeaderboardResponse response =
                scoreService.updateScore(gameId, request);

        return ResponseEntity.ok(response);
    }

    /**
     * Gets the leaderboard for a game.
     *
     * GET /api/games/{gameId}/leaderboard
     */
    @GetMapping("/{gameId}/leaderboard")
    public ResponseEntity<List<LeaderboardResponse>> getLeaderboard(
            @PathVariable Long gameId) {

        List<LeaderboardResponse> leaderboard =
                scoreService.getLeaderboard(gameId);

        return ResponseEntity.ok(leaderboard);
    }
}