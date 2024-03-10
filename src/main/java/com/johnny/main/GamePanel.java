package com.johnny.main;

import com.johnny.inputs.KeyboardInputs;
import com.johnny.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;

    public GamePanel(){
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);

        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value){
        this.xDelta = value;
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta = value;
        repaint();
    }

    public void setRectPosition(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
