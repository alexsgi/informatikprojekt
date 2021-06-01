package com.stickjumper.utils.components;

import com.stickjumper.utils.manager.ImageManager;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class InternetStateLabel extends JLabel {

    private boolean active;

    public InternetStateLabel() {
        super();
        setSize(ImageManager.ICON_INTERNET_AVAILABLE.getWidth(), ImageManager.ICON_INTERNET_AVAILABLE.getHeight());
    }

    public void setIcon(BufferedImage image) {
        if (image != null) setIcon(new ImageIcon(image));
    }

    public void setInternetEnabledStatus() {
        setIcon(ImageManager.ICON_INTERNET_AVAILABLE);
        active = true;
    }

    public void setInternetDisabledStatus() {
        setIcon(ImageManager.ICON_INTERNET_UNAVAILABLE);
        active = false;
    }

    public void flipStatus() {
        if (active) {
            setInternetDisabledStatus();
        } else {
            setInternetEnabledStatus();
        }
    }

}
