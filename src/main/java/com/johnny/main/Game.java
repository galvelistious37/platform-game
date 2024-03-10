package com.johnny.main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {
        gameWindow = new GameWindow(new GamePanel());
    }

}
