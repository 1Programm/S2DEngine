package com.progen.engine.s2dengine.testPackageGame;

import com.progen.engine.s2dengine.core.GameContext;
import com.progen.engine.s2dengine.core.S2DEngine;
import com.progen.engine.s2dengine.core.Scene;


public class PingPong {


    public static void main(String[] args) {
        S2DEngine engine = new S2DEngine("PingPong", 1000, 1000);
        engine.setTicks(120);
        engine.setFps(60);
        Scene scene = new Scene();


        scene.addGameObject(new PingPongBall(500,800));


        scene.addGameObject(new WeirdThingyYouPushTheBallWith(450,900));




        engine.registerScene("StartScene", scene);
        engine.loadScene("StartScene");
        engine.start();
    }
}
