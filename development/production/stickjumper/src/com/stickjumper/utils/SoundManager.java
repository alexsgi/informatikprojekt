package com.stickjumper.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {

    public static String pathButtonSound;
    public static String pathButtonSound2;
    public static String bootSound;

    public static void loadAllClips() {
        pathButtonSound = "/sounds/button_sound_1.wav";
        pathButtonSound2 = "/sounds/Winding-Alarm-Clock.wav";
        // bootSound = "/sounds/empty-boot-sequence.wav";
        bootSound = "/sounds/boot-2.wav";
        bootSound = "/sounds/boot-sound.wav";
    }

    public static void initSoundsAndBoot() {
        playSound(bootSound);
    }

    public static void playSound(final String url) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        UITools.class.getResourceAsStream(url));
                clip.open(inputStream);
                clip.start();
                clip.setMicrosecondPosition(0);
            } catch (Exception e) {
                Settings.logData("Error playing sound", e);
            }

        }).start();
    }
}

