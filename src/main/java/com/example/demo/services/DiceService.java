package com.example.demo.services;

import com.example.demo.responses.DiceResponse;

// Interface for dice operations
public interface DiceService {

    /**
     * Rolls the requested number of dice.
     *
     * @param sides number of sides on each die
     * @param quantity number of dice to roll
     * @return dice roll results
     */
    DiceResponse rollDice(int sides, int quantity);
}
