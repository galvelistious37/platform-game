package com.johnny.main;

import com.johnny.inputs.KeyboardInputs;
import com.johnny.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img, subImage;

    public GamePanel(){
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);
        importImage();

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
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta =y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        subImage = img.getSubimage(1*64, 7*40, 64, 40);
        g.drawImage(subImage, (int) xDelta, (int) yDelta, 128, 80, null);
    }
}
