package com.example.demo.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.GameSession;
import com.example.demo.models.PlayerScore;
import com.example.demo.repositories.GameSessionRepository;
import com.example.demo.repositories.PlayerScoreRepository;
import com.example.demo.requests.UpdateScoreRequest;
import com.example.demo.responses.LeaderboardResponse;

// Provides score update and leaderboard operations.
@Service
public class ScoreServiceImpl implements ScoreService {

    private final GameSessionRepository gameSessionRepository;
    private final PlayerScoreRepository playerScoreRepository;

    public ScoreServiceImpl(
            GameSessionRepository gameSessionRepository,
            PlayerScoreRepository playerScoreRepository) {

        this.gameSessionRepository = gameSessionRepository;
        this.playerScoreRepository = playerScoreRepository;
    }

    /**
     * Updates a player's score in a game.
     *
     * @param gameId the game identifier
     * @param request contains player name and points earned
     * @return updated player score
     */
    @Override
    @Transactional
    public LeaderboardResponse updateScore(
            Long gameId,
            UpdateScoreRequest request) {

        // Check whether the game exists
        GameSession game = gameSessionRepository.findById(gameId)
                .orElseThrow(() ->
                        new RuntimeException("Game not found"));

        // Find the player's score in this game
        List<PlayerScore> players =
                playerScoreRepository.findByGameId(gameId);

        PlayerScore player = players.stream()
                .filter(p -> p.getPlayerName()
                        .equals(request.getPlayerName()))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(
                                "Player not found in this game"));

        // Make sure the player belongs to the requested game
        if (!player.getGame().getId().equals(game.getId())) {
            throw new RuntimeException(
                    "Player does not belong to this game");
        }

        // Add the points earned in this turn
        player.setCurrentScore(
                player.getCurrentScore() + request.getPoints());

        PlayerScore savedPlayer =
                playerScoreRepository.save(player);

        return new LeaderboardResponse(
                savedPlayer.getPlayerName(),
                savedPlayer.getCurrentScore()
        );
    }

    /**
     * Returns the leaderboard sorted by score
     * from highest to lowest.
     *
     * @param gameId the game identifier
     * @return sorted leaderboard
     */
    @Override
    @Transactional(readOnly = true)
    public List<LeaderboardResponse> getLeaderboard(Long gameId) {

        // Check whether the game exists
        gameSessionRepository.findById(gameId)
                .orElseThrow(() ->
                        new RuntimeException("Game not found"));

        // Fetch all players in the game
        List<PlayerScore> players =
                playerScoreRepository.findByGameId(gameId);

        // Sort by score in descending order
        return players.stream()
                .sorted(Comparator.comparingInt(
                        PlayerScore::getCurrentScore
                ).reversed())
                .map(player -> new LeaderboardResponse(
                        player.getPlayerName(),
                        player.getCurrentScore()
                ))
                .toList();
    }
}