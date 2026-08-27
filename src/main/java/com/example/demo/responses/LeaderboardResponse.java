package com.example.demo.responses;

// Response containing a player's leaderboard information
public class LeaderboardResponse {

    private String playerName;
    private int score;

    // Default constructor
    public LeaderboardResponse() {
    }

    // Constructor
    public LeaderboardResponse(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}