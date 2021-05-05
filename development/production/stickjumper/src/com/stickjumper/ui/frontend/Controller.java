package com.stickjumper.ui.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {

    private StartPanelView mainPanel;
    private MainFrameView frame;

    public Controller(StartPanelView view, MainFrameView frame) {
        this.mainPanel = view;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "PLAY":
                break;
            case "LOGIN":
                break;
            case "ACTION COMMAND":
                mainPanel.anpassenText("Neuer Text");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Methode aufgerufen (1)");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Methode aufgerufen");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Methode aufgerufen (2)");
    }
}
