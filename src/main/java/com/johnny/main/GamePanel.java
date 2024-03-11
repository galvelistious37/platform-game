package com.johnny.main;

import com.johnny.inputs.KeyboardInputs;
import com.johnny.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static com.johnny.utils.Constants.PlayerConstants.*;
import static com.johnny.utils.Constants.Directions.*;

public class GamePanel extends JPanel {
    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = RUNNING;
    private int playerDirection = -1;
    private boolean moving = false;

    public GamePanel(){
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);
        importImage();
        loadAnimations();

        setPanelSize();

        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/images/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadAnimations(){
        animations = new BufferedImage[9][6];

        for(int j = 0; j < animations.length; j++){
            for(int i = 0; i < animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setDirection(int direction){
        this.playerDirection = direction;
        moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= getSpriteAmount(playerAction)){
                aniIndex = 0;
            }
        }
    }

    private void setAnimation(){
        if(moving){
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    private void updatePos(){
        if(moving){
            switch(playerDirection){
                case LEFT -> xDelta -= 5;
                case UP -> yDelta -= 5;
                case RIGHT -> xDelta += 5;
                case DOWN -> yDelta += 5;
            }
        }
    }

    public void updateGame(){
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
    }

}
