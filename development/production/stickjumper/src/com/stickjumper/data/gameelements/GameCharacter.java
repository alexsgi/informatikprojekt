package com.stickjumper.data.gameelements;

import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;

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

    public GameCharacter(int skinType) {
        super(new Point(Settings.X_POSITION_GAME_CHARACTER, Settings.SCREEN_HEIGHT - Settings.SEA_LEVEL - dimens.getHeight()), dimens, true, ImageManager.PLAYER_SKIN_1, 0);
        this.skinType = skinType;
    }

    public static int getXValueDimens() {
        return dimens.getWidth();
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

    @Override
    public void hit() {
    }

}
