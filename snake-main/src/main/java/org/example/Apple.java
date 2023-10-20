package org.example;

import org.example.components.GamePanel;

import java.awt.*;
import java.util.Random;


public class Apple {
    private int x;
    private int y;
    private final Color color = Settings.getInstance().appleColor;


    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //========== LOGIC ==========

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, this.x, this.y, this.color);
    }

    public void getEaten(GamePanel gamePanel){
        if(gamePanel.snakeOccupiesWholeBoard()) return;
        moveToEmptySpot(gamePanel);
    }
    // This method ensures that the new apple will not be generated on the same unit where snake occupies.
    public void moveToEmptySpot(GamePanel gamePanel){
        Random random = new Random();
        int x;
        int y;

        do { 
            x = random.nextInt(GamePanel.GRID_WIDTH);
            y = random.nextInt(GamePanel.GRID_HEIGHT);
            gamePanel.repaint();
        } while(!gamePanel.isSpaceEmpty(x, y));

        this.x = x;
        this.y = y;
    }
}
