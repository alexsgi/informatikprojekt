package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;

import java.awt.*;

public class GameCharacter extends GameElement {

    private static final int width = 70, height = 78;
    private static final String imagePath = "/images/elements/skins/skin_1.png";
    private int skinType;
    private int highScore;

    public GameCharacter(Point p, int skinType) {
        super(p, width, height, true, imagePath);
        this.skinType = skinType;
    }

    public GameCharacter(Player player, Point p) {
        super(p, width, height, true, imagePath);
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
