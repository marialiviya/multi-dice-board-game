package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requests.CreateGameRequest;
import com.example.demo.responses.GameResponse;
import com.example.demo.services.GameService;

import jakarta.validation.Valid;

// REST controller for game operations

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    // Constructor
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Create a new game
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse createGame(
            @Valid @RequestBody CreateGameRequest request) {

        return gameService.createGame(request);
    }
}