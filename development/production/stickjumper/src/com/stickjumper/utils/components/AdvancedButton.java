package com.stickjumper.utils.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

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

    public void setIcon(ImageIcon icon) {
        if (icon != null) super.setIcon(icon);
    }

    public void setID(String id) {
        setName(id);
        setActionCommand(id);
    }

}