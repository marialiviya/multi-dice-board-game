package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.responses.DiceResponse;
import com.example.demo.services.DiceService;

// REST controller for virtual dice operations.

@RestController
@RequestMapping("/api/dice")
public class DiceController {

    private final DiceService diceService;

    // Constructor
    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    // Roll one or more dice
    @GetMapping("/roll")
    public DiceResponse rollDice(
            @RequestParam(defaultValue = "6") int sides,
            @RequestParam(defaultValue = "1") int quantity) {

        return diceService.rollDice(sides, quantity);
    }
}