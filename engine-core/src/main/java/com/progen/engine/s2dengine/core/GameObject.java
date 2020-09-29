package com.progen.engine.s2dengine.core;

import java.awt.*;

public  class GameObject {

    protected float x,y;
    
    protected  void update(GameContext gameContext){

    }

    protected  void render(Graphics g) {

    }

    protected void init(GameContext gameContext) {

    }




    public GameObject addMouseListener (GameContext gameContext) {

        return this;
    }

    public GameObject addKeyListener (GameContext gameContext) {

        return this;
    }
}
