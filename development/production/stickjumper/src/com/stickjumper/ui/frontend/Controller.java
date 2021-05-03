package com.stickjumper.ui.frontend;

import com.stickjumper.ui.frontend.boot.LoadingFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private MainFrameView mainFrameView;
    private LoadingFrameView loadingFrameView;

    public Controller() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getActionCommand());
    }
}
