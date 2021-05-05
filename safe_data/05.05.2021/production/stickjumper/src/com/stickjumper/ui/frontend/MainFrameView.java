package com.stickjumper.ui.frontend;

import com.stickjumper.utils.MyCallback;
import com.stickjumper.utils.UITools;

import javax.swing.*;

public class MainFrameView extends JFrame {

    private JPanel panel;

    public MainFrameView() {

        // Can't change size of window
        setResizable(false);
        // Title of window
        setTitle("StickJumper");
        // What happens when you click on X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size of window
        setSize(1280, 640);
        // Window in center of screen
        setLocationRelativeTo(null);
        // Add panel to frame
        setContentPane(new StartPanelView(new MyCallback() {
            @Override
            public void play() {
                changePanel(new GamePanelView());
                revalidate();
            }
        }));
        // Set icon
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));
    }

    public void changePanel(JPanel newPanel) {
        panel = newPanel;
        setContentPane(panel);
    }

}
