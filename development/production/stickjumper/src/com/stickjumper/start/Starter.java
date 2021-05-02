package com.stickjumper.start;

import com.stickjumper.database.DBConnection;
import com.stickjumper.ui.frontend.MainFrameView;
import com.stickjumper.ui.frontend.StartPanelView;
import com.stickjumper.ui.frontend.boot.LoadingFrameView;
import com.stickjumper.ui.frontend.boot.LoadingPanelView;
import com.stickjumper.utils.UITools;

public class Starter {

    public static void main(String[] args) throws InterruptedException {
        // Load Windows UI config
        UITools.initUI();
        // Prepare and start loading screen
        LoadingPanelView loadingPanelView = new LoadingPanelView();
        LoadingFrameView loadingFrameView = new LoadingFrameView(loadingPanelView);
        loadingFrameView.setVisible(true);

        // Init shut down hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Code to run when shutting down software
            DBConnection.close();
        }));
        // Make all boot operations (db connection, ...)
        DBConnection.init();
        // Just to see loading frame (freezes cpu)
        Thread.sleep(4000);

        // Close loading screen
        loadingFrameView.dispose();

        // Open main frame
        StartPanelView panel = new StartPanelView();
        MainFrameView view = new MainFrameView(panel);
        view.setVisible(true);

    }


}