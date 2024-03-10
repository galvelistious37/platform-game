package com.johnny.main;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GamePanel gamePanel) {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        setVisible(true);
    }
}
