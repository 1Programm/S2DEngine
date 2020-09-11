package com.progen.engine.s2dengine.core;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
    }

    Main() {
        Window window = new Window(Core.WINDOW_WIDTH, Core.WINDOW_HEIGHT, Core.WINDOW_NAME, true);
        Engine engine = new Engine();
        engine.init();
    }
}
