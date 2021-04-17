package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameView extends JFrame {

	public FrameView(JPanel contentPane) {
		setResizable(false);
		setTitle("StickJumper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
	}

}
