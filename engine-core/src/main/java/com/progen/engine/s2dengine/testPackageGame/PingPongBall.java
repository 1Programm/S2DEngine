package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.GameContext;
import com.progen.engine.s2dengine.core.GameObject;
import com.progen.engine.s2dengine.maths.Vector2f;

import java.awt.*;

public class PingPongBall extends GameObject {

    Vector2f vel = new Vector2f(500f, -100);
    Vector2f size = new Vector2f(20, 20);
    Vector2f middlePoint = new Vector2f();

    public PingPongBall(float x, float y) {
        this.x = x;
        this.y = y;
        middlePoint.set(x + size.getX() / 2, y + size.getY() / 2);
    }


    @Override
    protected void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int) x, (int) y, 20, 20);
    }

    @Override
    protected void update(GameContext gameContext) {
        if (y <= 0) vel.mul(1, -1);
        if (x <= 0 || x >= gameContext.getWindow().getWidth()) vel.mul(-1, 1);

        x += vel.getX() * gameContext.getDelta();
        y += vel.getY() * gameContext.getDelta();
        middlePoint.set(x + size.getX() / 2, y + size.getY() / 2);
    }

    public Vector2f getVel() {
        return vel;
    }

    public Vector2f getSize() {
        return size;
    }

    public Vector2f getMiddlePoint() {
        return middlePoint;
    }

    public void setVel(Vector2f vel) {
        this.vel = vel;
    }

    public void setSize(Vector2f size) {
        this.size = size;
    }

    public void setMiddlePoint(Vector2f middlePoint) {
        this.middlePoint = middlePoint;
    }
}


