package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.GameSession;
import com.example.demo.models.GameStatus;
import com.example.demo.models.PlayerScore;
import com.example.demo.repositories.GameSessionRepository;
import com.example.demo.requests.CreateGameRequest;
import com.example.demo.responses.GameResponse;


//Provides the implementation of game session operations.

@Service
public class GameServiceImpl implements GameService {

    private final GameSessionRepository gameSessionRepository;

    /**
     * Creates a GameServiceImpl with the required repository.
     *
     * @param gameSessionRepository repository used to store game sessions
     */
    public GameServiceImpl(
            GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    /**
     * Creates a new game session and adds the specified players.
     * Each player starts with a score of zero.
     *
     * @param request contains the game name and player names
     * @return details of the newly created game
     */
    @Override
    @Transactional
    public GameResponse createGame(CreateGameRequest request) {

        // Create a new game with ACTIVE status
        GameSession game = new GameSession(
                request.getGameName(),
                GameStatus.ACTIVE
        );

        // Create a PlayerScore for each player
        for (String playerName : request.getPlayers()) {

            PlayerScore player = new PlayerScore(
                    playerName,
                    0,
                    game
            );

            game.getPlayers().add(player);
        }

        // Save the game and its players
        GameSession savedGame =
                gameSessionRepository.save(game);

        // Convert entity to response
        return new GameResponse(
                savedGame.getId(),
                savedGame.getGameName(),
                savedGame.getStatus(),
                savedGame.getPlayers()
                        .stream()
                        .map(PlayerScore::getPlayerName)
                        .toList()
        );
    }
}