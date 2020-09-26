package com.progen.engine.s2dengine.core;

import javax.swing.*;
import java.awt.*;

public class S2DWindow extends JFrame {

    private Canvas canvas;

    S2DWindow(int width, int height, String title, boolean resizable) {
       super(title);
       this.setResizable(resizable);

       canvas = new Canvas();
       canvas.setSize(width, height);
       this.add(canvas);
       this.pack();
       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);

    }

    public Canvas getCanvas(){
        return canvas;
    }

}
