package com.stickjumper.frontend.rendering;

import com.stickjumper.data.GameElement;

import javax.swing.*;

public class GameElementRender extends JLabel {

    private final GameElement gameElement;

    public GameElementRender(GameElement gameElement) {
        this.gameElement = gameElement;
        setIcon(new ImageIcon(gameElement.getImage()));
        setLocation(gameElement.getLocation());
        setSize(gameElement.getDimens().getWidth(), gameElement.getDimens().getHeight());
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
