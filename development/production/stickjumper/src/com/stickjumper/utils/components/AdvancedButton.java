package com.stickjumper.utils.components;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class AdvancedButton extends JButton {

    public AdvancedButton() {
        super();
        setFocusable(false);
        setBackground(null);
        setOpaque(false);
        setBorderPainted(false);
        setFocusable(false);
        setBorder(null);
    }

    public void setIcon(BufferedImage image) {
        if (image != null) super.setIcon(new ImageIcon(image));
    }

    public void setIcon(ImageIcon icon) {
        if (icon != null) super.setIcon(icon);
    }
}
