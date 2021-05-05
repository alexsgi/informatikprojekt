package com.stickjumper.ui.frontend;

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
        mainPanel.anpassenText("SPACE");
    }

    public void enterPressed() {
        mainPanel.anpassenText("ENTER");
    }

    public void disableMainFrame() {
        mainFrameView.setVisible(false);
    }

    public void enableMainFrame() {
        mainFrameView.setVisible(true);
    }


}
