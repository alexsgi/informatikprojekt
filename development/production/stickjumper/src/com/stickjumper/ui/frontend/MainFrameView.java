package com.stickjumper.ui.frontend;

import com.stickjumper.utils.MyCallback;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameView extends JFrame implements KeyListener {

    private StartPanelView panel;
    private Controller controller;

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
        // Set icon
        setIconImage(UITools.getImage(getClass(), "/images/icons/appicon_5.png"));
        // Add panel to frame

        controller = new Controller();
        this.addKeyListener(this);

        panel = new StartPanelView(new MyCallback() {
            @Override
            public void play() {
                //changePanel(new GamePanelView());

            }
        }, controller);

        controller.setPanel(panel);


        setContentPane(panel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        controller.keyPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    /*public void changePanel(JPanel newPanel) {
        panel = newPanel;
        setContentPane(panel);
        revalidate();
    }

     */

}
