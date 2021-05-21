package com.stickjumper.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundManager {

    public static String pathButtonSound = "/sounds/button_sound_1.wav";
    public static String pathButtonSound2 = "/sounds/Winding-Alarm-Clock.wav";
    public static String pathBootSound = "/sounds/boot-2.wav";

    public static AudioInputStream inputStreamBootSound, inputStreamButtonSound;

    public static void loadAllClips() {
        try {
            inputStreamBootSound = AudioSystem.getAudioInputStream(SoundManager.class.getResourceAsStream(pathBootSound));
            inputStreamButtonSound = AudioSystem.getAudioInputStream(SoundManager.class.getResourceAsStream(pathButtonSound2));
            // next AudioInputStreams
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void initSoundsAndBoot() {
        playSound(inputStreamBootSound);
    }

    public static void playSound(AudioInputStream inputStream) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.start();
                clip.setMicrosecondPosition(0);
                loadAllClips();
            } catch (Exception e) {
                Settings.logData("Error playing sound " + e.getLocalizedMessage(), e);
            }

        }).start();
    }

        /*
    public static void playSound(final String url) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        SoundManager.class.getResourceAsStream(url));
                clip.open(inputStream);
                clip.start();
                clip.setMicrosecondPosition(0);
            } catch (Exception e) {
                Settings.logData("Error playing sound", e);
            }

        }).start();
    }
     */
}

