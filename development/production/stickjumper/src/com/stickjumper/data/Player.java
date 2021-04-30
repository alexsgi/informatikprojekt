package com.stickjumper.data;

public class Player {

    private int key;
    private String playerName;
    private String playerPassword;
    private int highScore;

    public Player(int key, String playerName, String playerPassword, int highScore) {
        this.key = key;
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.highScore = highScore;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public String toString() {
        return String.format("Player %s (%d) - Highscore: %s - Password: %s", playerName, key, highScore, playerPassword);
    }
}
