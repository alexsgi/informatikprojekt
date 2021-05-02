package com.stickjumper.database;

import com.stickjumper.data.Player;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Alex
 */
public class DBConnection {

    private static final String DB_URL = "sql11.freesqldatabase.com";
    private static final String DB_NAME = "sql11404194";
    private static final String DB_USERNAME = "sql11404194";
    private static final String DB_PASSWORD = "bXItgyjBxd";
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

    public static ArrayList<Player> getAllPlayers() throws SQLException {
        if (!init) throw new SQLException("init() not called");
        // Prepare list and player object
        ArrayList<Player> list = new ArrayList<>();
        Player player;
        // Execute SQL: select all players
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
        // Add players to list if player not null
        while (rs.next()) {
            player = Player.fromResultSet(rs);
            if (player != null) list.add(player);
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
        ArrayList<Player> list = new ArrayList<>();
        Player player;
        // Execute SQL: select player with specific name
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE playername='" + playerName + "';");
        // Add players to list if player not null
        while (rs.next()) {
            player = Player.fromResultSet(rs);
            if (player != null) list.add(player);
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
        return list.get(0);
    }

    public static void main(String[] args) throws SQLException {
        // Call on loading screen
        DBConnection.init();

        ArrayList<Player> list = getAllPlayers();
        System.out.println("Number of players: " + list.size());
        for (Player p : list) {
            System.out.println(p);
        }

        // Call on end
        DBConnection.close();
    }
}
