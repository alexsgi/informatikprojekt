package com.stickjumper.frontend.boot;

import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadingPanelView extends JPanel {

    private JLabel loadingLabel = new JLabel();

    public LoadingPanelView() {
        setLayout(null);
        loadingLabel.setText("Loading ...");
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadingLabel.setBounds(0, 250, 1080, 50);
        loadingLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        // Set text color to white
        loadingLabel.setForeground(Color.WHITE);
        add(loadingLabel);

        JLabel gifLabel = new JLabel();
        //ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/loading_screen/gif1.gif"));
        //gifLabel.setIcon(imageIcon);
        gifLabel.setBounds(600, 200, 50, 50);
        add(gifLabel);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), "/images/loading_screen/sky.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

}