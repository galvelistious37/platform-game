package com.johnny.inputs;

import com.johnny.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.johnny.utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W -> gamePanel
                    .getGame()
                    .getPlayer()
                    .setDirection(UP);
            case KeyEvent.VK_S -> gamePanel
                    .getGame()
                    .getPlayer()
                    .setDirection(DOWN);
            case KeyEvent.VK_A -> gamePanel
                    .getGame()
                    .getPlayer()
                    .setDirection(LEFT);
            case KeyEvent.VK_D -> gamePanel
                    .getGame()
                    .getPlayer()
                    .setDirection(RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W,
                    KeyEvent.VK_S,
                    KeyEvent.VK_A,
                    KeyEvent.VK_D -> gamePanel
                    .getGame()
                    .getPlayer()
                    .setMoving(false);
        }
    }
}
