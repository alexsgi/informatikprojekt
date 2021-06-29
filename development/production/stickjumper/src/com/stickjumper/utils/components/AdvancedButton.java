package com.stickjumper.utils.components;

import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.SoundManager;
import com.stickjumper.utils.manager.StringManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AdvancedButton extends JButton {

    /*
    KINDS OF BUTTONS:
    - no border, no MouseListener
    - no border, changing text colors
    - no border, changing icons
    - with border, with icon (or null)
     */

    private static final ArrayList<AdvancedButton> list = new ArrayList<>();
    private String key;

    public AdvancedButton() {
        super();
        setFocusable(false);
        setFont(Settings.FONT_BUTTON_PLAIN);
        list.add(this);
    }

    public AdvancedButton(Color enterColor, Color exitColor) {
        super();
        list.add(this);
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
                setForeground(enterColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(exitColor);
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
        list.add(this);
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
                setIcon(enterImage);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setIcon(exitImage);
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

    public static void refresh() {
        for (AdvancedButton b : list) {
            if (b.getKey() != null) {
                b.setKeyText(b.getKey());
            }
        }
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

    public void setKeyText(String key) {
        this.key = key;
        setText((key == null || key.equals("")) ? "" : StringManager.getString(key));
    }

    public String getKey() {
        return key;
    }

}