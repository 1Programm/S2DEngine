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
    private float fps= 60;

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
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            boolean rendered = false;

            while(delta >= 1){
                update(delta);
                if(showFps) updates++;
                delta--;
                rendered = true;
            }

            if(rendered){
                preRender();
            }


            if(showFps) {
                frames++;

                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    log.trace("FPS: {} - TICKS: {}", frames, updates);
                    fps = updates;
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


}
