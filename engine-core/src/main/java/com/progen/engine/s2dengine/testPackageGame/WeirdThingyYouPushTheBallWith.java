package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.GameContext;
import com.progen.engine.s2dengine.core.GameObject;

import java.awt.*;

public class WeirdThingyYouPushTheBallWith extends GameObject {

    private boolean hasPressedListener = false;
    private boolean hasReleasedListener = false;

    private float vel = 1000;

    private float width, height;

    WeirdThingyYouPushTheBallWith(float x, float y) {
        this.x = x;
        this.y = y;
        width = 100;
        height = 10;
    }

    @Override
    protected void update(GameContext gameContext) {
        if (gameContext.getKeyBoard().isKeyPressed('A')) {
            if (x > 0) x -= gameContext.getDelta() * vel;
        }
        if (gameContext.getKeyBoard().isKeyPressed('D')) {
            if (x < gameContext.getWindow().getWidth() - width) x += gameContext.getDelta() * vel;
        }
    }

    @Override
    protected void render(Graphics g) {
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    protected void init(GameContext gameContext) {
        addKeyListener(gameContext);
    }


}
