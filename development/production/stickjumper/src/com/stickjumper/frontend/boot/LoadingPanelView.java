package com.stickjumper.frontend.boot;

import com.stickjumper.utils.Settings;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadingPanelView extends JPanel {

    public LoadingPanelView(LoadingFrameView frame) {
        super();
        setLayout(null);

        JLabel loadingLabel = new JLabel();
        loadingLabel.setText("Loading ...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setBounds(0, 250, frame.getWidth(), 50);
        loadingLabel.setFont(Settings.FONT_HEADING_SMALL);
        loadingLabel.setForeground(Color.WHITE);
        add(loadingLabel);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), Settings.LOADING_FRAME_BACKGROUND_IMAGE_PATH);
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

}