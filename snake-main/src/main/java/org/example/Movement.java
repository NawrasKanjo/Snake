package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//this class is needed to use the method kePressed() which will wait for a key to be pressed on the keyboard
public class Movement extends KeyAdapter {
    private static boolean leftDirection;
    private static boolean rightDirection;
    private static boolean upDirection;
    private static boolean downDirection;
    private static boolean hasUsedNewDirection = false;

    public static boolean isLeftDirection() {
        return leftDirection;
    }

    public static boolean isRightDirection() {
        return rightDirection;
    }

    public static boolean isUpDirection() {
        return upDirection;
    }

    public static boolean isDownDirection() {
        return downDirection;
    }

    public static void directionWasUsed(){
        hasUsedNewDirection = true;
    }

    public static void resetDirections(){
        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;
    }

    //This is an Override method which should control the snakes movement based on the key pressed!
    @Override
    public void keyPressed(KeyEvent e){
        if(!hasUsedNewDirection){ //prevents the snake from being able to go back into itself from too quick inputs
            return;
        }

        int keyCode = e.getKeyCode();
        //if the UP Arrow key is pressed AND the snake is not moving down then the head will move UP
        if (keyCode == KeyEvent.VK_UP && !downDirection){
            upDirection = true;
            leftDirection = false;
            rightDirection =false;
        }
        //if the DOWN Arrow key is pressed AND the snake is not moving up then the head will move DOWN
        else if (keyCode == KeyEvent.VK_DOWN && !upDirection) {
            downDirection = true;
            leftDirection = false;
            rightDirection = false;
        }
        //if the RIGHT Arrow key is pressed AND the snake is not moving left then the head will move RIGHT
        else if (keyCode == KeyEvent.VK_RIGHT && !leftDirection) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        //if the LEFT Arrow key is pressed AND the snake is not moving right then the head will move LEFT
        else if (keyCode == KeyEvent.VK_LEFT && !rightDirection){
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }
        //invalid input
        else {
            return;
        }

        hasUsedNewDirection = false;
    }
}


