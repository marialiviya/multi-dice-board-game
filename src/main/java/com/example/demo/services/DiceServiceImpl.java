package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.demo.responses.DiceResponse;

//Implements the virtual dice service.
@Service
public class DiceServiceImpl implements DiceService {

    /**
     * Rolls the requested number of dice and generates
     * random values using ThreadLocalRandom.
     *
     * @param sides number of sides on each die
     * @param quantity number of dice to roll
     * @return dice results and total
     */
    @Override
    public DiceResponse rollDice(int sides, int quantity) {

        if (sides < 2) {
            throw new IllegalArgumentException(
                    "Dice must have at least 2 sides"
            );
        }

        if (quantity < 1) {
            throw new IllegalArgumentException(
                    "Quantity must be at least 1"
            );
        }

        List<Integer> results = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < quantity; i++) {

            int result = ThreadLocalRandom.current()
                    .nextInt(1, sides + 1);

            results.add(result);
            total += result;
        }

        return new DiceResponse(
                sides,
                quantity,
                results,
                total
        );
    }
}