package com.stickjumper.start;

import com.stickjumper.data.database.DBConnection;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.UITools;

import java.io.IOException;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        List list = null;

        // INTERNET CONNECTION TEST
        boolean connectionAvailable = serverConnectionTest();
        if (connectionAvailable) {
            // Init shut down hook
            // Code to run when shutting down software
            Runtime.getRuntime().addShutdownHook(new Thread(DBConnection::close));
            // Make all internet boot operations (db connection, ...)
            DBConnection.init();
            //list = DBConnection.getAllPlayers(); // -> TODO: List
        }

        // boot operations

        // no internet connection -> one single Player to locally save data until you close the game

        // Create main frame
        MainFrameView mainFrameView = new MainFrameView();
        mainFrameView.addPlayerList(list);

        // Close loading screen
        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
    }

    public static boolean serverConnectionTest() throws InterruptedException, IOException {
        // SPECIFIED FOR WINDOWS! NOT macOS OR UNIX
        Process p1 = java.lang.Runtime.getRuntime().exec("ping -n 1 stickjumper.ddns.net");
        int returnVal = p1.waitFor();
        return (returnVal == 0);
    }

}