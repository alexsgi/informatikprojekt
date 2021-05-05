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

    public void spacePressed() {
        mainPanel.anpassenText("lol");
    }

    public void enterPressed(){
        mainPanel.anpassenText("Enter");
    }
}
