package com.stickjumper.data.database;

import com.stickjumper.data.Player;
import com.stickjumper.data.list.List;

import java.sql.*;

public class DBConnection {

    private static final String DB_URL = "stickjumper.ddns.net";
    private static final String DB_NAME = "stickjumper";
    private static final String DB_USERNAME = "stickjumperuser";
    private static final String DB_PASSWORD = "XcZa746Awf43468SO736ZmOZRS";
    private static final String DB_TABLE_NAME = "player_table";

    private static Connection connection;
    private static Statement stmt;

    private static boolean init = false;

    private DBConnection() {
    }

    public static void init() {
        if (init) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s/%s?user=%s&password=%s",
                    DB_URL, DB_NAME, DB_USERNAME, DB_PASSWORD));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ex.printStackTrace();
            return;
        }
        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        init = true;
    }

    public static void close() {
        if (!init) return;
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ignore) {
            }
            stmt = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignore) {
            }
            connection = null;
        }
        init = false;
    }

    public static List getAllPlayers() throws SQLException {
        if (!init) throw new SQLException("init() not called");
        // Prepare list and player object
        List list = new List();
        Player player;
        // Execute SQL: select all players
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
        // Add players to list if player not null
        while (rs.next()) {
            player = Player.fromResultSet(rs);
            if (player != null) list.insert(player);
        }
        try {
            rs.close();
        } catch (SQLException ignore) {
        }
        return list;
    }

    public static Player getPlayer(String playerName) throws SQLException {
        if (!init) throw new SQLException("init() not called");
        // Prepare list and player object
        List list = new List();
        Player player;
        // Execute SQL: select player with specific name
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE playername='" + playerName + "';");
        // Add players to list if player not null
        while (rs.next()) {
            player = Player.fromResultSet(rs);
            if (player != null) list.insert(player);
        }
        // Close result set
        try {
            rs.close();
        } catch (SQLException ignore) {
        }
        // Player not found
        if (list.size() == 0) return null;
        // More than one player with same username found: massive error!
        if (list.size() > 1) {
            throw new SQLException("More than one player found!");
        }
        return list.getRootPlayer();
    }

    public static boolean updateHighScore(Player player) throws SQLException {
        String sql = String.format("UPDATE %s SET highscore=? WHERE playername=? AND playerpassword =?", DB_TABLE_NAME);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, player.getHighScore());
        preparedStatement.setString(2, player.getPlayerName());
        preparedStatement.setString(3, player.getPlayerPassword());
        int rowsAffected = preparedStatement.executeUpdate();
        // 1 = ok; 0 = error (e.g. player not found)
        return rowsAffected == 1;
    }

    public static boolean registerPlayer(String username, String password) throws SQLException {
        Player checkIfExists = getPlayer(username);
        if (checkIfExists != null) return false;
        // TODO: Hash password?
        String sql = String.format("INSERT INTO %s (playername, playerpassword, highscore, skin) VALUES (?, ?, ?, ?)",
                DB_TABLE_NAME);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setInt(3, 0);
        preparedStatement.setInt(4, 0);
        // Check documentation of executeUpdate() !
        preparedStatement.executeUpdate();
        return getPlayer(username) != null;
    }

}
