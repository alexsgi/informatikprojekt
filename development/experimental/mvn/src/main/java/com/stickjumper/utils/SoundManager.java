package com.stickjumper.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;

public class SoundManager {

    public static String pathButtonSound = "/sounds/button_sound_1.wav";
    public static String pathButtonSound2 = "/sounds/Winding-Alarm-Clock.wav";
    public static String pathBootSound = "/sounds/boot-2.wav";
    public static String pathBootSoundEmpty = "/sounds/empty-boot-sequence.wav";
    public static String pathCoinSound = "/sounds/coin.wav";
    public static String pathGameOverSound = "/sounds/DunDunDun.wav";

    public static AudioInputStream inputStreamBootSound, inputStreamButtonSound, inputStreamCoinSound, inputStreamGameOverSound;

    public static void loadAllClips() {
        pathButtonSound2 = pathBootSoundEmpty;
        try {
            inputStreamBootSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathBootSoundEmpty)));
            inputStreamButtonSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathButtonSound2)));
            inputStreamCoinSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathCoinSound)));
            inputStreamGameOverSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathGameOverSound)));
        } catch (UnsupportedAudioFileException | IOException | NullPointerException e) {
            Settings.logData("Error loading sounds", e);
        }
    }

    public static void bootSoundManager() {
        playSound(inputStreamBootSound);
    }

    public static void playSound(AudioInputStream inputStream) {
        // TODO: don't load all input streams, only used ones
        if (Settings.SOUND_EFFECTS_ON) {
            if (inputStream == inputStreamGameOverSound && !Settings.GAME_OVER_MUSIC_ON) return;
            new Thread(() -> {
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.start();
                    clip.setMicrosecondPosition(0);
                    loadAllClips();
                } catch (Exception e) {
                    Settings.logData("Error playing sound: " + e.getMessage(), e);
                }
            }).start();

        }
    }

}

