package com.stickjumper.utils.manager;

import com.stickjumper.utils.Settings;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;

public class SoundManager {

    public static final String pathBootSound = "/sounds/boot_2.wav";
    public static final String pathBootSoundEmpty = "/sounds/empty_clip.wav";
    public static final String pathCoinSound = "/sounds/coin_sound.wav";
    public static final String pathGameOverSound = "/sounds/game_over.wav";
    public static AudioInputStream inputStreamBootSound, inputStreamCoinSound, inputStreamGameOverSound, inputStreamCheatSound;

    public static void loadAllClips() {
        try {
            inputStreamBootSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathBootSoundEmpty)));
            inputStreamCoinSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathCoinSound)));
            inputStreamGameOverSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathGameOverSound)));
            inputStreamCheatSound = AudioSystem.getAudioInputStream(new BufferedInputStream(SoundManager.class.getResourceAsStream(pathBootSound)));
        } catch (UnsupportedAudioFileException | IOException | NullPointerException e) {
            Settings.logData("Error loading sounds", e);
        }
    }

    public static void bootSoundManager() {
        playSound(inputStreamBootSound);
    }

    public static void playSound(AudioInputStream inputStream) {
        if (Settings.SOUND_EFFECTS_ON) {
            if (inputStream == inputStreamGameOverSound && !Settings.GAME_OVER_MUSIC_ON) return;
            new Thread(() -> {
                try {
                    Clip clip = AudioSystem.getClip();
                    clip.open(inputStream);
                    clip.setMicrosecondPosition(0);
                    clip.start();
                    loadAllClips();
                } catch (Exception e) {
                    Settings.logData("Error playing sound", e);
                }
            }).start();
        }
    }

}

