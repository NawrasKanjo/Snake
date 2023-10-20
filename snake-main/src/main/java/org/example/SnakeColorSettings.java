package org.example;

import java.awt.*;
import java.util.Random;

public class SnakeColorSettings {
    // The default colour of the snake if the user did not choose the customization option
    private static Color headColor = Color.decode("#00ff00");
    private static Color bodyColor = Color.decode("#00dd00");

    public static boolean isRandomColor = false;

    public static Color getHeadColor(){
        if(isRandomColor){
            return getRandomColor();
        }
        return headColor;
    }

    public static Color getBodyColor(){
        if(isRandomColor){
            return getRandomColor();
        }
        return bodyColor;
    }

    public static void setColors(Color headColor, Color bodyColor) {
        SnakeColorSettings.headColor = headColor;
        SnakeColorSettings.bodyColor = bodyColor;
    }

    public static Color getRandomColor(){
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }
}


