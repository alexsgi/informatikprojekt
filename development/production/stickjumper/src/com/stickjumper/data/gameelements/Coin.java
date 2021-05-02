package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;

public class Coin extends GameElement {

    private final int coinValue;


    public Coin(int coinValue) {
        super();
        this.setVisible(true);
        this.coinValue = coinValue;
    }

    // Default coinValue
    public Coin() {
        super();
        this.setVisible(true);
        this.coinValue = 10;
    }


    public void hit(){
        // increase HighScore
    }

}
