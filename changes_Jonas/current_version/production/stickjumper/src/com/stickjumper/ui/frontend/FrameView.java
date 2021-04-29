package com.stickjumper.ui.frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static jdk.internal.jshell.tool.JShellTool.getResource;

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

        Image img = Toolkit.getDefaultToolkit().getImage(this.class.getResource("image.png"))
        this.setIconImage(img);

    }
}
