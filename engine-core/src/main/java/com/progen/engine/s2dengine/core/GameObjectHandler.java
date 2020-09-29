package com.progen.engine.s2dengine.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectHandler {
    List<GameObject> objList = new ArrayList();


    public void update (GameContext gameContext) {
        for(int i=0;i<objList.size();i++) {
            objList.get(i).update(gameContext);
        }
    }

    public void render (Graphics g) {
        for(int i=0;i<objList.size();i++) {
            objList.get(i).render(g);
        }
    }

    public void init(GameContext gameContext) {
        for(int i=0;i<objList.size();i++) {
            objList.get(i).init(gameContext);
        }
    }


    public void addObject (GameObject obj) {
        objList.add(obj);
    }

    public void removeObject (Object obj) {
        objList.remove(obj);
    }

    public void clear () {
        objList.clear();
    }

    public void load (List<GameObject> objList) {
        this.objList.addAll(objList);
    }
}
