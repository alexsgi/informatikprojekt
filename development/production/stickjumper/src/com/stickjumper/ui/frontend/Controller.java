package com.stickjumper.ui.frontend;

public class Controller {

    private StartPanelView mainPanel;

    public Controller() {
    }

    public void setPanel(StartPanelView panel) {
        mainPanel = panel;
    }

    public void newMethod() {
        mainPanel.anpassenText("Es funzt");

    }

    public void keyPressed() {

        mainPanel.anpassenText("lol");
    }
}
