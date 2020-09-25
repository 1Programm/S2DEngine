package com.progen.engine.s2dengine.core;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Scene {

    List<GameObject> gameObjects = new ArrayList<>();

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);
    }
}
