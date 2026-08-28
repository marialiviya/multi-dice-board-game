package com.example.demo.services;

import com.example.demo.requests.CreateGameRequest;
import com.example.demo.responses.GameResponse;

//Defines the operations related to game sessions.
 
public interface GameService {

    /**
     * Creates a new game session with the given players.
     *
     * @param request contains the game name and player names
     * @return details of the created game
     */
    GameResponse createGame(CreateGameRequest request);
}