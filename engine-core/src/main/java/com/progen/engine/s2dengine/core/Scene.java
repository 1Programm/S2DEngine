package com.progen.engine.s2dengine.core;

import java.util.*;

public class Scene {

    List<GameObject> gameObjects = new ArrayList<>();

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
