package com.stickjumper.ui.frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FrameView extends JFrame {

    public FrameView(JPanel contentPane) throws MalformedURLException {
        setResizable(false);
        setTitle("StickJumper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 640);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setAppIcon();
    }

    public void setAppIcon() throws MalformedURLException {
        URL url = new URL("src/res/images/all_images");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        this.setIconImage(img);

    }
}
