package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.ImageManager;
import com.stickjumper.utils.Settings;

import java.awt.*;

public class GameCharacter extends GameElement {

    public static final int width = 70, height = 78;
    public static final Dimens dimens = new Dimens(70, 78);
    private int skinType;
    private int highScore;

    public GameCharacter(Point p, int skinType) {
        super(p, dimens, true, ImageManager.PLAYER_SKIN_1, 0);
        this.skinType = skinType;
    }

    public GameCharacter(Player player, Point p) {
        super(p, dimens, true, ImageManager.PLAYER_SKIN_1, 0);
        highScore = player.getHighScore();
    }

    public GameCharacter(int skinType){
        super(new Point(Settings.xPositionGameCharacter, Settings.SCREEN_HEIGHT-Settings.seaLevel-dimens.getHeight()), dimens, true, ImageManager.PLAYER_SKIN_1, 0);
        this.skinType = skinType;
    }

    public int getSkinType() {
        return skinType;
    }

    public int getHighScore() {
        return highScore;
    }

    public Dimens getDimens() {
        return dimens;
    }

    public static int getXValueDimens() {
        return dimens.getWidth();
    }

    @Override
    public void hit() {

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
    */
}
