package com.progen.engine.s2dengine.core;

import com.progen.engine.s2dengine.io.keyboard.IKeyInput;
import com.progen.engine.s2dengine.io.mouse.IMouseInput;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GameContext {
    private ISceneHandler sceneHandler;

    private IMouseInput mouse;
    private IKeyInput keyBoard;
    private S2DWindow window;
    @Setter
    private double delta;

    public void init(ISceneHandler sceneHandler ,IMouseInput mouse, IKeyInput keyBoard, S2DWindow window) {
        this.mouse = mouse;
        this.keyBoard = keyBoard;
        this.window = window;
        this.sceneHandler = sceneHandler;
    }

}
