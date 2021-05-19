package com.stickjumper.utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UITools {

    public static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getImage(Class<?> c, String path) {
        try {
            InputStream in = c.getResourceAsStream(path);
            if (in == null) return null;
            return ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("The image (%s) was not loaded\n", path);
        }
        return null;
    }

    public static AudioInputStream getSound(Class<?> c /*, String path */ ){
        try {
            URL url = c.getClassLoader().getResource("sounds/button_sound_1.wav");
            AudioInputStream audioIn;
            audioIn = AudioSystem.getAudioInputStream(url);

            if (audioIn == null) return null;
            return audioIn;
        } catch (IOException | UnsupportedAudioFileException e ) {
            e.printStackTrace();
            System.out.printf("The track (%s) was not loaded\n"+ "sounds/button_sound_1.wav");
        }
        return null;
        
        
    }
}
