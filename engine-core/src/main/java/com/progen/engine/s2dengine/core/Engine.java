package com.progen.engine.s2dengine.core;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine {

    boolean running = true;
    private float fps= 60;

    boolean showFps = false;

    public Engine() {
        Window window = new Window(Core.WINDOW_WIDTH, Core.WINDOW_HEIGHT, Core.WINDOW_NAME, true);
    }


    private void update (double delta){

    }

    private void render (Graphics g) {

    }

    private void run() {

        double lastTime = System.nanoTime();
        double amountOfTicks = 1 / fps;
        double delta = 0;
        double timer = System.currentTimeMillis();


        int updates = 0;
        int frames = 0;

        double fpstime = 0;

        while (running) {

            double now = System.nanoTime();
            delta = (now - lastTime);

            fpstime += ((now - lastTime) / 1000000000.0);
            lastTime = now;

            update(delta);
            if (showFps) updates++;

            if (fpstime >= amountOfTicks) {

                preRender();
                frames++;
                fpstime = 0;
            }


            if (showFps) {
                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames + " - TICKS: " + updates);
                    frames = 0;
                    updates = 0;
                }
            }
        }
    }

    private void preRender() {
        BufferStrategy bs = Core.canvas.getBufferStrategy();
        if (bs == null) {
            Core.canvas.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        render(g);
    }



}
