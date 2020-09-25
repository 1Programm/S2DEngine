package com.progen.engine.s2dengine.core;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Started Main Method");
        Main main = new Main();
    }
    private Player player;
    Main() {
        Engine engine = new Engine();
        Scene startScene = new Scene();
        startScene.addGameObject(player);
//        engine.registerScene("startScene", startScene);
//        engine.loadScene("startScene");
//        engine.start();
    }
}
