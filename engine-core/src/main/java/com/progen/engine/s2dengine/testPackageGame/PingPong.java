package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.S2DEngine;
import com.progen.engine.s2dengine.core.Scene;

public class PingPong {

    public static void main(String[] args) {
        S2DEngine engine = new S2DEngine("PingPong", 1000, 1000);
        Scene scene = new Scene();
        scene.addGameObject(new PingPongBall(29,20));
        scene.addGameObject(new WeirdThingyYouPushTheBallWith());

        engine.registerScene("StartScene", scene);
        engine.loadScene("StartScene");
        engine.start();
    }
}
