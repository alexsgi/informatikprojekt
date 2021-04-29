package Main;

import javax.swing.UIManager;

import frontend.FrameView;
import frontend.StartView;

public class Main {

    public static void main(String[] args) {
        initUI();
        StartView panel = new StartView();
        FrameView view = new FrameView(panel);
        view.setVisible(true);
    }

    private static void initUI() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}