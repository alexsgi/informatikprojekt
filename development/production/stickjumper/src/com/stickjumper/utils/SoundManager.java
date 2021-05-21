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
        bootSound = "/sounds/empty-boot-sequence.wav";
        bootSound = "/sounds/boot-2.wav";



    }
    public static void initSoundsAndBoot(){
        playSound(bootSound);
    }


    public static void playSound(final String url /*,  boolean notFirstPlay */) {
        new Thread(() ->{
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    UITools.class.getResourceAsStream(url));
            clip.open(inputStream);
            /*
            if(!notFirstPlay){ FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(0);
            }
             */
            clip.start();
            clip.setMicrosecondPosition(0);
        } catch (Exception e) {
            Settings.logData("Error playing sound", e);
        }

    }).start();}
}

