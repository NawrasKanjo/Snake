package org.example;

import org.example.components.GamePanel;

import java.awt.*;

public class BodyPart {
    private int x;
    private int y;
    private Color color = SnakeColorSettings.getBodyColor();

    public BodyPart(int x, int y){
        this.x = x;
        this.y = y;
    }

    //========== GETTERS ==========

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    //========== SETTERS ==========

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics graphics){
        GamePanel.fillRect(graphics, getX(), getY(), color);
    }
}
