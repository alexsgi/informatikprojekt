package com.stickjumper.database;

import com.stickjumper.data.Player;

import java.sql.*;

public class DBConnection {

    private static final String DB_URL = "sql11.freesqldatabase.com";
    private static final String DB_NAME = "sql11404194";
    private static final String DB_USERNAME = "sql11404194";
    private static final String DB_PASSWORD = "bXItgyjBxd";

    private Connection connection;
    private Statement stmt;
    private ResultSet rs;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
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
            rs = stmt.executeQuery("SELECT * FROM test_table");
            Player player;
            System.out.println("DATABASE OUTPUT:");
            while (rs.next()) {
                player = new Player(
                        rs.getInt("key"), rs.getString("playername"), rs.getString("playerpassword"), rs.getInt("highscore")
                );
                System.out.println(player);
            }
            System.out.println("--- END OF DATABASE OUTPUT ---");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {
                } // ignore
                stmt = null;
            }
        }
    }

    public static void main(String[] args) {
        new DBConnection();
    }
}
