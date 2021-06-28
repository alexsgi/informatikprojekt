package com.stickjumper.data.gameelements;

import com.stickjumper.controller.scenerycontrolling.GameEventListener;
import com.stickjumper.data.GameElement;
import com.stickjumper.data.Player;
import com.stickjumper.utils.Dimens;
import com.stickjumper.utils.Settings;
import com.stickjumper.utils.manager.ImageManager;

import java.awt.*;

public class GameCharacter extends GameElement {

    public static final Dimens dimens = new Dimens(70, 78);
    private int skinType;

    public GameCharacter(Player player) {
        super(new Point(Settings.X_POSITION_GAME_CHARACTER, Settings.SCREEN_HEIGHT - Settings.SEA_LEVEL - dimens.getHeight()), dimens, true, player == null ? ImageManager.PLAYER_SKIN_1 : player.getSkin() == 0 ? ImageManager.PLAYER_SKIN_1 : (player.getSkin() == 1 ? ImageManager.PLAYER_SKIN_2 : ImageManager.PLAYER_SKIN_3), 0);
    }

    public GameCharacter(int skinType) {
        super(new Point(Settings.X_POSITION_GAME_CHARACTER, Settings.SCREEN_HEIGHT - Settings.SEA_LEVEL - dimens.getHeight()), dimens, true, ImageManager.PLAYER_SKIN_1, 0);
        this.skinType = skinType;
    }

    public static int getWidth() {
        return dimens.getWidth();
    }

    public int getSkinType() {
        return skinType;
    }

    public Dimens getDimens() {
        return dimens;
    }

    @Override
    public void hit() {
    }

    @Override
    public void addEventListener(GameEventListener listener) {
    }


}
