package com.stickjumper.start;

import com.stickjumper.ui.frontend.FrameView;
import com.stickjumper.ui.frontend.StartView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Starter {
    static BufferedImage image = getIcon();
    public static void main(String[] args) {
        initUI();
        StartView panel = new StartView();
        FrameView view = new FrameView(panel);
        view.setVisible(true);

       ImageIcon icon = new ImageIcon(image);
        // Create an image instance from the image that you want to use as icon for your app
        view.setIconImage(image);
        // And set it
     /*   String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for ( int i = 0; i < fonts.length; i++ )
        {
            System.out.println(fonts[i]);
        }*/
        //This is a Method to print out all the available fonts
    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getIcon() {
        try {
            InputStream in = Starter.class.getResourceAsStream("/res/images/appicon_5.png");
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
            System.exit(1);
        }
        return null;
    }

}