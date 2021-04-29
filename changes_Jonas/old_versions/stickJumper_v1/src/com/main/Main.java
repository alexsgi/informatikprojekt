package com.main;

import javax.swing.UIManager;

import com.frontend.FrameView;
import com.frontend.StartView;

public class Main {

    public static void main(String[] args) {
        initUI();
        StartView panel = new StartView();
        FrameView view = new FrameView(panel);
        view.setVisible(true);
    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.play.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
