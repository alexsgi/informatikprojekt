package com.stickjumper.frontend.game;

import com.stickjumper.data.gameelements.Coin;
import com.stickjumper.frontend.rendering.GameElementRender;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.*;

public class GamePanelView extends JPanel {

    private final Font MAIN_FONT = UITools.registerFont();
    private JLabel lblTitle;

    public GamePanelView() {
        setLayout(null);
        lblTitle = new JLabel("GamePanel");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 96, 1280, 83);
        lblTitle.setFont(MAIN_FONT);
        add(lblTitle);

        GameElementRender coinElement = new GameElementRender(new Coin(new Point(50, 50)));
        add(coinElement);

    }

}
