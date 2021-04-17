package frontend;

public class Application {

	public static void main(String[] args) {

		StartView panel = new StartView();
		FrameView view = new FrameView(panel);
		view.setVisible(true);
	}

}
