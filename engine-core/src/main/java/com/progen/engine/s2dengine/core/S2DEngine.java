package com.progen.engine.s2dengine.core;

import com.progen.engine.s2dengine.io.keyboard.StandardKeyInput;
import com.progen.engine.s2dengine.io.mouse.StandardMouseInput;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class S2DEngine implements ISceneHandler{

    private final S2DWindow window;

    private final GameObjectHandler gObjHandler;
    private final GameContext gContext;
    private final Map<String, Scene> sceneMap = new HashMap<>();

    private boolean showFps = true;
    private boolean running = false;

    private int fps = 60;
    private float ticks = 300;

    public S2DEngine(String name, int width, int height) {
        window = new S2DWindow(width, height, name, true);
        gObjHandler = new GameObjectHandler();
        gContext = new GameContext();
        StandardMouseInput mouseInput = new StandardMouseInput();
        StandardKeyInput keyInput = new StandardKeyInput();
        window.getCanvas().addMouseListener(mouseInput);
        window.getCanvas().addMouseMotionListener(mouseInput);
        window.getCanvas().addKeyListener(keyInput);

        gContext.init(this ,mouseInput, keyInput, window);
    }

    private void update (double delta){
        gContext.setDelta(delta);
        gObjHandler.update(gContext);
    }

    private void render (Graphics g) {
        gObjHandler.render(g);
    }

    public void start() {
        if(running)  return;
        running = true;
        run();
    }

    private void run() {

        double ns = 1000000000 ;

        long lastTime = System.nanoTime();
        double lastTimeFps = 0;

        double delta = 0;

        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        boolean rendered = false;

        while(running){

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTimeFps += (now - lastTime) / ns;

            lastTime = now;

            while(delta >= 1.0/ticks){
                update(delta);
                if(showFps) updates++;
                delta -= 1.0/ticks;
                rendered = true;
            }

            if(rendered && lastTimeFps >= 1.0/fps){
                preRender();
                if(showFps)frames++;
                lastTimeFps = 0;
                rendered = false;
            }


            if(showFps) {
                if(System.currentTimeMillis() - timer > 1000){

                    timer += 1000;
                    log.trace("FPS: {} - TICKS: {}", frames, updates);
                    frames = 0;
                    updates = 0;
                }
            }
        }

    }

    private void preRender() {
        BufferStrategy bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, window.getWidth(), window.getHeight());
        render(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void registerScene(String name, Scene scene) {
        sceneMap.put(name, scene);
    }

    @Override
    public void loadScene (String name) {
        gObjHandler.clear();
        Scene scene = sceneMap.get(name);
        gObjHandler.load(scene.getGameObjects());
        log.info("loaded Scene: " + name);
    }


    public void setFps(int fps) {
        this.fps = fps;
    }
    public void setTicks(float ticks) {
        this.ticks = ticks;
    }
}
