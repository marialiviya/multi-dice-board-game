package com.example.demo.responses;

import java.util.List;

/**
 * Represents the result of a dice roll.
 */
public class DiceResponse {
private final int sides;
private final int quantity;
private final List<Integer> results;
private final int total;

    /**
     * Creates a dice response.
     *
     * @param sides number of sides on each die
     * @param quantity number of dice rolled
     * @param results individual dice results
     * @param total sum of all dice results
     */
    public DiceResponse(
            int sides,
            int quantity,
            List<Integer> results,
            int total
    ) {
        this.sides = sides;
        this.quantity = quantity;
        this.results = results;
        this.total = total;
    }

    public int getSides() {
        return sides;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Integer> getResults() {
        return results;
    }

    public int getTotal() {
        return total;
    }
}