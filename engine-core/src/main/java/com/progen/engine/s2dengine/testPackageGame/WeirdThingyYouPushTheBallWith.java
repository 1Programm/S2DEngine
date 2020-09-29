package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.GameContext;
import com.progen.engine.s2dengine.core.GameObject;
import com.progen.engine.s2dengine.io.keyboard.IKeyEventListener;
import com.progen.engine.s2dengine.maths.Vector2f;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WeirdThingyYouPushTheBallWith extends GameObject {

    private boolean hasPressedListener = false;
    private boolean hasReleasedListener = false;

    private float vel = 1000;

    WeirdThingyYouPushTheBallWith(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void update(GameContext gameContext) {
            if(gameContext.getKeyBoard().isKeyPressed('A')) x -= gameContext.getDelta()*vel;
        if (gameContext.getKeyBoard().isKeyPressed('D')) x += gameContext.getDelta()*vel;
    }

    @Override
    protected void render(Graphics g) {
        g.fillRect( (int) x, (int) y ,100, 10);
    }

    @Override
    protected void init(GameContext gameContext) {
        addKeyListener(gameContext);
    }
}
