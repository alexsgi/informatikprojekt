package com.stickjumper.database;

import com.stickjumper.data.Player;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private static final String DB_URL = "sql11.freesqldatabase.com";
    private static final String DB_NAME = "sql11404194";
    private static final String DB_USERNAME = "sql11404194";
    private static final String DB_PASSWORD = "bXItgyjBxd";
    private static final String DB_TABLE_NAME = "player_table";

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;

    private static boolean init = false;

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
            rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            Player player;
            System.out.println("DATABASE OUTPUT:");
            while (rs.next()) {
                player = Player.fromResultSet(rs);
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

    public static void init() {
        if(init) return;
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
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        init = true;
    }

    public static void close() {
        if(!init) return;
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ignore) {}
            stmt = null;
        }
    }

    public static ArrayList<Player> fetchAllData() throws SQLException {
        if(!init) throw new SQLException("init() not called");
        rs = stmt.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
        ArrayList<Player> list = new ArrayList<>();
        Player player;
        while (rs.next()) {
            player = Player.fromResultSet(rs);
            if(player != null) list.add(player);
        }
        try {
            rs.close();
        } catch(SQLException ignore) {}
        rs = null;
        return list;
    }

    public static void main(String[] args) throws SQLException {
        DBConnection.init();
        ArrayList<Player> list = fetchAllData();
        for(Player p : list) {
            System.out.println(p);
        }
        DBConnection.close();
    }
}
