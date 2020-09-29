package com.progen.engine.s2dengine.io.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class StandardKeyInput extends KeyAdapter implements IKeyInput{

    private final List<Integer> keys = new ArrayList<>();

    private final List<IKeyEventListener> keyPressedListeners = new ArrayList<>();
    private final List<IKeyEventListener> keyReleasedListeners = new ArrayList<>();

    @Override
    public boolean isKeyPressed(int key) {
        return keys.contains(key);
    }

    @Override
    public void addOnPressedListener(IKeyEventListener listener) {
        keyPressedListeners.add(listener);
    }

    @Override
    public void addOnReleasedListener(IKeyEventListener listener) {
        keyReleasedListeners.add(listener);
    }

    //KeyAdapter

    @Override
    public void keyPressed(KeyEvent e) {
        keys.add(e.getKeyCode());
        for(IKeyEventListener keyListener : keyPressedListeners) {
            keyListener.onEvent(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove((Object) e.getKeyCode());
        for(IKeyEventListener keyListener : keyReleasedListeners) {
            keyListener.onEvent(e.getKeyCode());
        }
    }

}