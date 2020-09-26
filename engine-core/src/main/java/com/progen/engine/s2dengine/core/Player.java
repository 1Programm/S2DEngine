package com.progen.engine.s2dengine.core;

import java.awt.*;

public class Player extends GameObject {

    @Override
    protected void update(GameContext gameContext) {
        if(gameContext.getMouse().isLeftPressed()) {
            this.x = gameContext.getMouse().getMouseX();
            this.y = gameContext.getMouse().getMouseY();
        }

        if (gameContext.getMouse().isRightPressed()) {
            gameContext.getSceneHandler().loadScene("TEST");
        }
    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int) x,(int) y,100,100);
    }


}
