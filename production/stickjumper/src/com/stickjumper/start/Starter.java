package com.stickjumper.start;

import com.stickjumper.ui.frontend.FrameView;
import com.stickjumper.ui.frontend.StartView;

import javax.swing.UIManager;

public class Starter {

    public static void main(String[] args) {
        initUI();
        StartView panel = new StartView();
        FrameView view = new FrameView(panel);
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