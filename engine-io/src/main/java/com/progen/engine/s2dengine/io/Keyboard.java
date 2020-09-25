package com.progen.engine.s2dengine.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keyboard implements KeyListener {

    private ArrayList<Character> pressedKeys = new ArrayList();


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(!pressedKeys.contains(e.getKeyChar())) {
            pressedKeys.add(e.getKeyChar());
        }
    }

    public void keyReleased(KeyEvent e) {
        if(pressedKeys.contains(e.getKeyChar())) {
            pressedKeys.remove(e.getKeyChar());
        }
    }


    public boolean isKey(char key) {
        if(pressedKeys.contains(key)) {
            return true;
        }
        return false;
    }

}
