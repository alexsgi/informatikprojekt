package com.stickjumper.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {

    private final int key;
    private int highScore, skin;
    private String playerName, playerPassword;

    public Player(int key, String playerName, String playerPassword, int highScore, int skin) {
        this.key = key;
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.highScore = highScore;
        this.skin = skin;
    }

    public static Player fromResultSet(ResultSet rs) throws SQLException {
        int k, h, s;
        String n, p;
        k = rs.getInt("key");
        n = rs.getString("playername");
        p = rs.getString("playerpassword");
        h = rs.getInt("highscore");
        s = rs.getInt("skin");
        if (k < 0 || h < 0 || s < 0 || n == null || p == null) {
            return null;
        }
        return new Player(k, n, p, h, s);
    }

    public void updatePlayerOnDB(){
        // TODO upload all necessary information on DB
    }

    public int getKey() {
        return key;
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

    public int getSkin() {
        return skin;
    }

    public void setSkin(int skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return String.format("Player %s (%d) - Highscore: %s - Password: %s - Skin: %d", playerName, key, highScore, playerPassword, skin);
    }
}
