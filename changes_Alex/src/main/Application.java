package main;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import frontend.FrameView;
import frontend.StartView;

public class Application {

	public static void main(String[] args) {
		initUI();
		StartView panel = new StartView();
		FrameView view = new FrameView(panel);
		view.setVisible(true);

		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
	}

	private static void initUI() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}