package com.stickjumper.data.GameElements;

/**
 * author Jonas
 */

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;

public class GameCharacter extends GameElement {

    private  int skinType;
    private int highScore;

    public GameCharacter(int yPos, int skinType) {
        super();
        this.setYPos(yPos);
        this.skinType = skinType;
        this.setVisible(true);
    }

    public GameCharacter(Player player) {
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
            highScore = highScore + num;
        }
    }

    public void increaseHighScore(){
        // this method increases the HighScore by a default number
        highScore = highScore + 10;
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
        // TODO: This will be the method that uploads the new HighScore to the DB via DBConnection
    }
    */
}
