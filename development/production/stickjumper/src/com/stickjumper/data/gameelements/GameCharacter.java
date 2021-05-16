package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.utils.variables.ImageManager;

import java.awt.*;

public class GameCharacter extends GameElement {

    public static final int width = 70 + ImageManager.padding, height = 78 + ImageManager.padding;
    private int skinType;
    private int highScore;

    public GameCharacter(Point p, int skinType) {
        super(p, width, height, true, ImageManager.PLAYER_SKIN_1);
        this.skinType = skinType;
    }

    public GameCharacter(Player player, Point p) {
        super(p, width, height, true, ImageManager.PLAYER_SKIN_1);
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
