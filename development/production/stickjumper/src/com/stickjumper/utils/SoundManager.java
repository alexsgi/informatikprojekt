package com.stickjumper.utils;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;

public class SoundManager {


    public static String pathButtonSound;

    public static void loadAllClipPaths() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        pathButtonSound = "/sounds/button_sound_1.wav";
        // playSound(pathButtonSound, false);
    }



    public static void playSound(final String url /*,  boolean notFirstPlay */) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    UITools.class.getResourceAsStream(url));
            clip.open(inputStream);
            // if(!notFirstPlay){ FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            //     volume.setValue(0);}
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
