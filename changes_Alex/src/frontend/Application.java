package frontend;

import java.awt.EventQueue;
import frontend.*;

@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView panel = new StartView();
					FrameView view = new FrameView(panel);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
