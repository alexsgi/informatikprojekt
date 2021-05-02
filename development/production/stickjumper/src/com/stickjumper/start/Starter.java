package com.stickjumper.start;

import com.stickjumper.database.DBConnection;
import com.stickjumper.ui.frontend.MainFrameView;
import com.stickjumper.ui.frontend.StartPanelView;
import com.stickjumper.ui.frontend.boot.LoadingFrameView;
import com.stickjumper.ui.frontend.boot.LoadingPanelView;

import javax.swing.*;

public class Starter {

    public static void main(String[] args) throws InterruptedException {
        // Load Windows UI config
        initUI();
        // Prepare and start loading screen
        LoadingPanelView loadingPanelView = new LoadingPanelView();
        LoadingFrameView loadingFrameView = new LoadingFrameView(loadingPanelView);
        loadingFrameView.setVisible(true);

        // Make all boot operations (db connection, ...)
        DBConnection.init();
        // Just to see loading frame
        Thread.sleep(4000);

        // Close loading screen
        loadingFrameView.dispose();

        // Open main frame
        StartPanelView panel = new StartPanelView();
        MainFrameView view = new MainFrameView(panel);
        view.setVisible(true);

    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}