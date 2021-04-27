package frontend;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartView extends JPanel {

	private Font AHARONI_FONT;

	public StartView() {
		registerFont();
		setLayout(null);

		JLabel lblTitel = new JLabel("StickJumper");
		// lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitel.setBounds(0, 96, 1280, 83);
		lblTitel.setFont(AHARONI_FONT);
		// lblTitel.setFont(AHARONI_FONT, Font.PLAIN, 30);
		add(lblTitel);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bgImage;
		try {
			bgImage = ImageIO.read(getClass().getResource("/res/mountains-middle.png"));
			g.drawImage(bgImage, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registerFont() {
		try {
			Font AHARONI_FONT = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/res/aharoni.ttf"));
			AHARONI_FONT.deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(AHARONI_FONT);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}
}
