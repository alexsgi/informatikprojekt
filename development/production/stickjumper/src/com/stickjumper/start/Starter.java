package com.stickjumper.start;

import com.stickjumper.data.database.DBConnection;
import com.stickjumper.frontend.MainFrameView;
import com.stickjumper.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.ConnectionTester;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingFrameView loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        long s1, e1;
        s1 = System.currentTimeMillis();
        int serverResponseCode = ConnectionTester.checkConnection();
        e1 = System.currentTimeMillis();
        Settings.logData("Network operation took " + (e1 - s1) + " ms");
        boolean connectionAvailable = serverResponseCode == ConnectionTester.CONNECTION_OK;
        if (!connectionAvailable) {
            // TODO: check before login, register and update highscore (db)
            JOptionPane.showMessageDialog(null, "Can not connect to the server -\ninternet connection available?");
            System.exit(1);
        }

        long start, end;
        start = System.currentTimeMillis();
        ImageManager.loadALlImages(loadingFrameView.getClass());
        end = System.currentTimeMillis();
        Settings.logData("Image loading took " + (end - start) + " ms");

        // Make all internet boot operations (db connection, ...)
        DBConnection.init();
        // Create main frame
        MainFrameView mainFrameView = new MainFrameView();
        mainFrameView.addPlayerListToController(DBConnection.getAllPlayers());

        // Close loading screen
        loadingFrameView.dispose();
        mainFrameView.setVisible(true);
    }

}