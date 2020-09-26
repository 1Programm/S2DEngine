package com.progen.engine.s2dengine.core;

public interface ISceneHandler {

    void registerScene (String name, Scene scene);
    void loadScene (String name);

}
