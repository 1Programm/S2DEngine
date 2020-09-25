package com.progen.engine.s2dengine.io.keyboard;

public interface IKeyInput {

    boolean isKeyPressed(int key);

    void addOnPressedListener(IKeyEventListener listener);
    void addOnReleasedListener(IKeyEventListener listener);
}
