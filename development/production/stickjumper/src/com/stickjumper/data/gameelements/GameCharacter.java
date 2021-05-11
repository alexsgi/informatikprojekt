package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;

import java.awt.*;

public class GameCharacter extends GameElement {

    private int skinType;
    private int highScore;
    private static Point p = new Point(0, 0);
    private static final int length = 64, width = 64;
    private static final String imagePath = "/images/elements/coin/coin.png";

    public GameCharacter(int yPos, int skinType) {
        super(new Point(p.x, yPos), length, width, true, imagePath);
        p.y = yPos;
        this.setY(yPos);
        this.skinType = skinType;
        this.setVisible(true);
    }

    public GameCharacter(Player player) {
        super(p, length, width, true, imagePath);
        highScore = player.getHighScore();
    }

    public int getSkinType() {
        return skinType;
    }

    public int getHighScore() {
        return highScore;
    }

    /*
    public void increaseHighScore(int num){
        if(num > 0){
            highScore += num;
        }
    }

    public void increaseHighScore(){
        // this method increases the HighScore by a default number
        highScore += 10;
    }

    public void setNewHighScore(int highScore){
        if(DBConnectionVal){
            if(this.highScore < highScore){
                this.highScore = highScore;
                uploadHighScoreToDB(highScore);
            }
        }
    }

    private void uploadHighScoreToDB(int newHighScore){
        // TODO: This will be the method that uploads the new highscore to the DB via DBConnection
    }
    */
}
