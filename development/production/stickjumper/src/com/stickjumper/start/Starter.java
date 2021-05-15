package com.stickjumper.start;

import com.stickjumper.data.database.DBConnection;
import com.stickjumper.data.list.List;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.UITools;
import com.stickjumper.utils.variables.ImageManager;

import java.io.IOException;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        long start, end;
        start = System.currentTimeMillis();
        ImageManager.loadALlImages(loadingFrameView.getClass());
        end = System.currentTimeMillis();
        System.err.println("Image loading took " + (end - start) + " ms");

        List list;
        // boolean connectionAvailable = serverConnectionTest();
        // if (connectionAvailable) {
        Runtime.getRuntime().addShutdownHook(new Thread(DBConnection::close));
        // Make all internet boot operations (db connection, ...)
        DBConnection.init();
        list = DBConnection.getAllPlayers();

        // Create main frame
        MainFrameView mainFrameView = new MainFrameView();
        mainFrameView.addPlayerListToController(list);

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