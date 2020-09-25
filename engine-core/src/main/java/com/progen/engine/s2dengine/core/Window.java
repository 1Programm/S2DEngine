package com.progen.engine.s2dengine.core;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    Window(int width, int height, String title, boolean resizable) {
       super(title);
       this.setResizable(resizable);

       Canvas canvas = new Canvas();
        canvas.setSize(width, height);
       this.add(canvas);
       this.pack();
       this.setVisible(true);

       Core.canvas = canvas;
    }

}
