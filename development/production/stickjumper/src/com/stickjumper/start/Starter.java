package com.stickjumper.start;

import com.stickjumper.database.DBConnection;
import com.stickjumper.ui.frontend.MainFrameView;
import com.stickjumper.ui.frontend.boot.LoadingFrameView;
import com.stickjumper.utils.UITools;

public class Starter {

    private static LoadingFrameView loadingFrameView;
    private static MainFrameView view;

    public static void main(String[] args) {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        loadingFrameView = new LoadingFrameView();
        loadingFrameView.setVisible(true);

        // Create main frame
        view = new MainFrameView();

        // Init shut down hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Code to run when shutting down software
            DBConnection.close();
        }));
        // Make all boot operations (db connection, ...)
        DBConnection.init();

        // Close loading screen
        loadingFrameView.dispose();
        view.setVisible(true);
    }

}