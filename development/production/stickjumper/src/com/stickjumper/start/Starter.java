package com.stickjumper.start;

import com.stickjumper.data.Player;
import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.UITools;

import java.sql.SQLException;
import java.util.ArrayList;

public class Starter {

    private static LoadingFrameView loadingFrameView;
    private static MainFrameView view;

    public static void main(String[] args) throws SQLException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        // INTERNET CONNECTION TEST

        // Init shut down hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Code to run when shutting down software
            DBConnection.close();
        }));
        // Make all boot operations (db connection, ...)
        DBConnection.init();
        ArrayList<Player> list = DBConnection.getAllPlayers(); // -> TODO: List
        // no internet connection -> one single Player to locally save data until you close the game

        // Create main frame
        view = new MainFrameView();
        view.addPlayerList(list);

        // some new comments

        // Close loading screen
        loadingFrameView.dispose();
        view.setVisible(true);
    }

}