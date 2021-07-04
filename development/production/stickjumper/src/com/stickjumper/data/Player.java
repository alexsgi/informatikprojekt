package com.stickjumper.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Player implements Comparable<Player> {

    private final int key;
    private final String playerName, playerPassword;
    private int highScore, skin;

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
        k = rs.getInt("pkey");
        n = rs.getString("playername");
        p = rs.getString("playerpassword");
        h = rs.getInt("highscore");
        s = rs.getInt("skin");
        if (k < 0 || h < 0 || s < 0 || n == null || p == null) {
            return null;
        }
        return new Player(k, n, p, h, s);
    }


    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPassword() {
        return playerPassword;
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
    public int compareTo(Player o) {
        return o.getHighScore() - highScore;
    }
}
