package com.stickjumper.ui.frontend;

import com.stickjumper.ui.frontend.login.LoginFrameView;
import com.stickjumper.ui.frontend.login.LoginPanelView;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class StartPanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();

    private JButton loginButton = new JButton();
    private JButton otherButton = new JButton();
    private int buttonCounter = 0;

    public StartPanelView(Controller controller) {
        setLayout(null);
        JLabel lblTitel = new JLabel("StickJumper");
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        lblTitel.setFont(MAIN_FONT);
        add(lblTitel);

        // this button should open up a new frame with a log in function
        loginButton.setText("Login");
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButton.setBounds(0, 150, 200, 50);
        loginButton.setVisible(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.disableMainFrame();
                LoginPanelView loginPanel = new LoginPanelView();
                LoginFrameView loginFrame = new LoginFrameView(loginPanel, controller);
                loginFrame.setVisible(true);
            }
        });
        add(loginButton);

        // the following button was just an experiment in order to try out whether that works with another actionListener
        otherButton.setText("PLAY");
        otherButton.setFont(new Font("Calibri", Font.PLAIN, 15));
        otherButton.setBounds(0, 200, 200, 50);
        otherButton.setVisible(true);
        otherButton.setFocusable(false);


        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newMethod();
            }
        });
        otherButton.setActionCommand("ACTION COMMAND");
        add(otherButton);
    }

    @Override
    protected void paintComponent(Graphics graphicsObject) {
        super.paintComponent(graphicsObject);
        BufferedImage image = UITools.getImage(getClass(), "/images/start_view/background/mountains-middle.png");
        if (image == null) return;
        graphicsObject.drawImage(image, 0, 0, null);
    }

    public void anpassenText(String neuerText) {
        otherButton.setText(neuerText);
    }
}