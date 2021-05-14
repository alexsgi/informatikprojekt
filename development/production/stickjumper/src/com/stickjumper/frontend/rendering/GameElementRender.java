package com.stickjumper.frontend.rendering;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.utils.UITools;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GameElementRender extends JLabel {

    private final GameElement gameElement;

    public GameElementRender(GameElement gameElement) {
        this.gameElement = gameElement;
        BufferedImage image = UITools.getImage(getClass(), gameElement.getImagePath());
        assert image != null; // TRY CATCH!
        setIcon(new ImageIcon(image));
        setLocation(gameElement.getLocation());
        setSize(gameElement.getHeight(), gameElement.getWidth());
    }

    public GameElement getGameElement() {
        return gameElement;
    }

    public void incrementX(int n) {
        gameElement.incrementX(n);
        setLocation(gameElement.getLocation());
    }

    public void incrementY(int n) {
        gameElement.incrementY(n);
        setLocation(gameElement.getLocation());
    }
}
