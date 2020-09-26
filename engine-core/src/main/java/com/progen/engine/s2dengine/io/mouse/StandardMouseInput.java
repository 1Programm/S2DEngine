package com.progen.engine.s2dengine.io.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StandardMouseInput extends MouseAdapter implements IMouseInput {

    private int mouseX;
    private int mouseY;
    private boolean left;
    private boolean right;
    private final List<IMouseEventListener> mousePressedListeners = new ArrayList<>();
    private final List<IMouseEventListener> mouseReleasedListeners = new ArrayList<>();

    @Override
    public int getMouseX() {
        return mouseX;
    }

    @Override
    public int getMouseY() {
        return mouseY;
    }

    @Override
    public boolean isLeftPressed() {
        return left;
    }

    @Override
    public boolean isRightPressed() {
        return right;
    }

    @Override
    public void addPressedListener(IMouseEventListener listener) {
        mousePressedListeners.add(listener);
    }

    @Override
    public void addReleasedListener(IMouseEventListener listener) {
        mouseReleasedListeners.add(listener);
    }

    // MouseListener

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            left = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            right = true;
        }

        for(IMouseEventListener listener : mousePressedListeners){
            listener.onEvent(this);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            left = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON2){
            right = false;
        }

        for(IMouseEventListener listener : mouseReleasedListeners){
            listener.onEvent(this);
        }
    }
}
