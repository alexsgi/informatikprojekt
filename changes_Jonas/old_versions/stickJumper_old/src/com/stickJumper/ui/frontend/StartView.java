package frontend;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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
        lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitel.setBounds(0, 96, 1280, 83);
        add(lblTitel);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Image bgImage;
        try {
            bgImage = ImageIO.read(getClass().getResource("/res/mountains-middle.png"));
            graphics.drawImage(bgImage, 0, 0, null);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }