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

    public int getSpeed(){
        return gameElement.getSpeed();

    }

    public void decrementX(int n) {
        gameElement.decrementX(n);
        setLocation(gameElement.getLocation());
    }

    public void decrementY(int n) {
        gameElement.decrementY(n);
        setLocation(gameElement.getLocation());
    }
}
