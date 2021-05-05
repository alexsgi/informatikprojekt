package com.stickjumper.start;

import com.stickjumper.data.Player;
import com.stickjumper.database.DBConnection;
import com.stickjumper.ui.frontend.MainFrameView;
import com.stickjumper.ui.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.UITools;

import java.sql.SQLException;
import java.util.ArrayList;

public class Starter {

    public static void main(String[] args) throws SQLException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        // Create main frame
        MainFrameView view = new MainFrameView();

        // Init shut down hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Code to run when shutting down software
            DBConnection.close();
        }));
        // Make all boot operations (db connection, ...)
        DBConnection.init();
        ArrayList<Player> list = DBConnection.getAllPlayers();
        for (Player p : list) {
            System.out.println(p.toString());
        }

        // Close loading screen
        loadingFrameView.dispose();
        view.setVisible(true);

    }

}