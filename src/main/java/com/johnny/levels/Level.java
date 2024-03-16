package com.johnny.levels;

public class Level {
    private int[][] lvlDate;

    public Level(int[][] lvlDate){
        this.lvlDate = lvlDate;
    }

    public int getSpriteIndex(int x, int y){
        return lvlDate[y][x];
    }
}
