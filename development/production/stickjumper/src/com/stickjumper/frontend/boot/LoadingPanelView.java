package com.stickjumper.frontend.boot;

import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.StringManager;
import com.stickjumper.utils.manager.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class LoadingPanelView extends JPanel {


    public LoadingPanelView(LoadingFrameView frame) {
        super(true);
        setLayout(null);
        setSize(frame.getWidth(), frame.getHeight());

        JLabel loadingLabel = new JLabel();
        loadingLabel.setText("Loading ...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setSize(getWidth(), 30);
        loadingLabel.setLocation(0, 10);
        loadingLabel.setFont(Settings.FONT_LOADING_HEADING_SMALL);
        loadingLabel.setForeground(Color.WHITE);
        // add(loadingLabel);

        JLabel lblTitle = new JLabel(Settings.APP_NAME);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setSize(getWidth(), 83);
        lblTitle.setLocation(0, 96);
        lblTitle.setFont(Settings.FONT_HEADING_BIG_BOLD);
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle);

        JLabel tipLabel = new JLabel();
        tipLabel.setText(getTipMessage());
        tipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tipLabel.setSize(getWidth(), 30);
        tipLabel.setLocation(0, getHeight() - tipLabel.getHeight() - 10);
        tipLabel.setFont(Settings.FONT_LOADING_HEADING_SMALL);
        tipLabel.setForeground(Color.WHITE);
        add(tipLabel);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), Settings.LOADING_FRAME_BACKGROUND_IMAGE_PATH);
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

    private String getTipMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        return switch (randomNum) {
            case 0 -> StringManager.getString("loading.hint0");
            case 1 -> StringManager.getString("loading.hint1");
            case 2 -> StringManager.getString("loading.hint2");
            default -> StringManager.getString("loading.hint3");
        };
        // return "Tip: you can jump by pressing SPACE";
    }

}