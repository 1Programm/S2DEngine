package com.progen.engine.s2dengine.core;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Started Main Method");
        Main main = new Main();
    }
    private Player player = new Player();
    Main() {
        S2DEngine engine = new S2DEngine("Test", 600, 500);
        Scene startScene = new Scene();
        startScene.addGameObject(player);
        engine.registerScene("TEST", new Scene());
        engine.registerScene("startScene", startScene);
        engine.loadScene("startScene");
        engine.start();
    }
}
