package com.progen.engine.s2dengine.core;

import java.util.ArrayList;
import java.util.List;

public class GameObjectHandler {
    List<GameObject> objList = new ArrayList();


    public void update () {
        for(GameObject obj : objList) {
            obj.update();
        }
    }

    public void render () {
        for(GameObject obj : objList) {
            obj.render();
        }
    }


    public void addObject (GameObject obj) {
        objList.add(obj);
    }

    public void removeObject (Object obj) {
        objList.remove(obj);
    }
}
