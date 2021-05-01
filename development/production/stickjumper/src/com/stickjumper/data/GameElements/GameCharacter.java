package com.stickjumper.data.GameElements;

import com.stickjumper.data.GameElement;

public class GameCharacter extends GameElement {

    private final int skinType;
    private int highScore;
    // private boolean DBConnectionVal;

    public GameCharacter(int yPos, int skinType /*, int highScoreFromDB, boolean DBConnectionVal */) {
        this.setxPos(yPos);
        this.skinType=skinType;
        this.setVisible(true);

        /*
        this.DBConnectionVal = DBConnectionVal;
        if (DBConnectionVal){
            this.highScore = highScoreFromDB;
        } else{
            this.highScore = 0;
        }
        */


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
