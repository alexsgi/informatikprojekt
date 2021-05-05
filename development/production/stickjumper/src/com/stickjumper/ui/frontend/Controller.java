package com.stickjumper.ui.frontend;

import java.awt.*;

public class Controller {

    private StartPanelView mainPanel;
    private MainFrameView mainFrameView;

    public Controller(MainFrameView mainFrameView) {
        this.mainFrameView = mainFrameView;
    }

    public void setPanel(StartPanelView panel) {
        mainPanel = panel;
    }

    public void newMethod() {
        mainPanel.anpassenText("Es funzt");
    }

    public void spacePressed() {
        mainPanel.anpassenText("lol");
    }

    public void enterPressed(){
        mainPanel.anpassenText("Enter");
    }

    public void disableMainFrame(){
        mainFrameView.setVisible(false);
    }

    public void enableMainFrame(){
        mainFrameView.setVisible(true);
    }


}
