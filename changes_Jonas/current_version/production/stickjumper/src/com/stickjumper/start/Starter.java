package com.stickjumper.start;

import com.stickjumper.ui.frontend.FrameView;
import com.stickjumper.ui.frontend.StartView;

import javax.swing.UIManager;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Starter {

    public static void main(String[] args) {
        initUI();
        StartView panel = new StartView();
        FrameView view = new FrameView(panel);
        view.setVisible(true);

        // Create an image instance from the image that you want to use as icon for your app
        String path="C:\\Users\\jonas\\Documents\\Projekte\\informatikprojekt\\changes_Jonas\\current_version\\production\\stickjumper\\src\\com\\stickjumper\\start";
        Image icon = Toolkit.getDefaultToolkit().getImage(path+"\\appicon_5.png");
        // And set it
        view.setIconImage(icon);
    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}