package com.progen.engine.s2dengine.io.mouse;

public interface IMouseInput {

    int getMouseX();
    int getMouseY();

    boolean isLeftPressed();
    boolean isRightPressed();

    void addPressedListener(IMouseEventListener listener);
    void addReleasedListener(IMouseEventListener listener);
    //...


}
