package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.GameContext;
import com.progen.engine.s2dengine.core.GameObject;
import com.progen.engine.s2dengine.maths.Vector2f;

import java.awt.*;

public class PingPongBall extends GameObject {

    Vector2f vel = new Vector2f(100f,100f);

    public PingPongBall(float x, float y) {
        this.x = x;
        this.y = y;
    }


    @Override
    protected void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int) x, (int)y, 20, 20);
    }

    @Override
    protected void update(GameContext gameContext) {
        x += vel.getX() * gameContext.getDelta();
        y += vel.getY() * gameContext.getDelta();
    }

}
