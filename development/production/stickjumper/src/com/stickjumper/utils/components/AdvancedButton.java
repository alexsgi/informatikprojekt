package com.stickjumper.utils.components;

import com.stickjumper.utils.UITools;
import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdvancedButton extends JButton {

    /*
    KINDS OF BUTTONS:
    - no border, no MouseListener
    - no border, changing text colors
    - no border, changing icons
    - with border, with icon (or null)
     */

    public AdvancedButton() {
        super();
        setFocusable(false);
        setBackground(null);
        setOpaque(false);
        setBorderPainted(false);
        setFocusable(false);
        setBorder(null);
    }

    public AdvancedButton(Color enterColor, Color exitColor) {
        super();
        setFocusable(false);
        setBackground(null);
        setOpaque(false);
        setBorderPainted(false);
        setFocusable(false);
        setBorder(null);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(exitColor);
                playSound("sounds/button_sound_1.wav");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(enterColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(exitColor);
            }
        });
    }

    public AdvancedButton(BufferedImage enterImage, BufferedImage exitImage) {
        super();
        setFocusable(false);
        setBackground(null);
        setOpaque(false);
        setBorderPainted(false);
        setFocusable(false);
        setBorder(null);
        setIcon(exitImage);
        setHorizontalAlignment(SwingConstants.CENTER);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(exitImage);
                playSound("sounds/button_sound_1.wav");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(enterImage);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(exitImage);
            }
        });
    }

    public AdvancedButton(BufferedImage image) {
        super();
        setFocusable(false);
        setIcon(image);
    }

    public void setIcon(BufferedImage image) {
        if (image != null) super.setIcon(new ImageIcon(image));
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        if (defaultIcon != null) super.setIcon(defaultIcon);
    }

    public void setID(String id) {
        setName(id);
        setActionCommand(id);
    }

    /* public void playSound(Class<?> c, final String path) {
        try {
            URL defaultSound = getClass().getResource("/sounds/button_sound_1.wav");
            // getClass().getSy.getResource("/images/ads/WindowsNavigationStart.wav");
            File soundFile = new File(defaultSound.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start( );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            getClass().getResourceAsStream("/sounds/button_sound_1.wav"));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
        */

    public void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            getClass().getResourceAsStream("/sounds/button_sound_1.wav"));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

}