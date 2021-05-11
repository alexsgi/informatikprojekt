package com.stickjumper.frontend.rendering;

import com.stickjumper.data.GameElement;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GameElementRender extends JLabel {

    private GameElement gameElement;

    public GameElementRender(GameElement gameElement) {
        this.gameElement = gameElement;
        BufferedImage image = UITools.getImage(getClass(), gameElement.getImagePath());
        assert image != null; // TRY CATCH!
        setIcon(new ImageIcon(image));
        setLocation(gameElement.getLocation());
        setSize(gameElement.getLength(), gameElement.getWidth());
    }

    public GameElement getGameElement() {
        return gameElement;
    }
}
