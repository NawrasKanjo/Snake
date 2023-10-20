package org.example;

import org.example.components.GameFrame;
import org.example.components.GamePanel;
import org.example.components.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Game implements Runnable{

    public static void setTickSpeed(int tickSpeed) {
        Game.tickSpeed = tickSpeed;
    }

    //Variables
    private static int tickSpeed = 100; // in milliseconds, default value

    private final GameFrame gameFrame;
    private final GamePanel gamePanel;
    private Snake snake;
    private Apple apple;

    Thread gameThread;
    private boolean gameIsRunning = true;

    public Game(){
        gameFrame = new GameFrame();
        gamePanel = gameFrame.addGamePanel();
    }


    //Methods
    public void start(){
        Movement.resetDirections();
        gameFrame.requestFocus(); //for keyboard listener to work
        apple = new Apple();
        snake = new Snake(GamePanel.GRID_WIDTH/2, GamePanel.GRID_HEIGHT/2);
        gamePanel.initialize(snake, apple);
        apple.moveToEmptySpot(gamePanel);

        Stopwatch.startTimer(); // starts the timer

        gameIsRunning = true;
        gameThread = new Thread(this); // Game.java implements Runnable
        gameThread.start();
    }

    //This method will run in a different thread. The game window will be unresponsive otherwise.
    @Override
    public void run() {
        while(gameIsRunning){
            try {
                TimeUnit.MILLISECONDS.sleep(tickSpeed);
                doGameTick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doGameTick(){
        //the order of these statements matters A LOT, be careful
        snake.move();
        Movement.directionWasUsed(); //to prevent snake from going back in on itself from rapid input
        if(snake.hasCollided(gamePanel)){
            failGame();
            return;
        }

        if(hasWon()){
            winGame();
            return;
        }

        if(snake.canEat(apple)){
            snake.eat(apple, gamePanel);
        }

        gamePanel.repaint(); //no changes are displayed until this is called
    }

    public boolean hasWon(){
        return snake.getLength() >= GamePanel.GRID_WIDTH * GamePanel.GRID_HEIGHT;
    }

    private void winGame(){
        System.out.println("Won game");
        gameIsRunning = false;
        gamePanel.showGameWon(this::restart); // :: method reference, passes method as argument
    }

    private void failGame(){
        System.out.println("Failed game");
        gameIsRunning = false;
        gamePanel.showGameOver(this::restart);  // :: method reference, passes method as argument
    }

    public void restart(){
        start();
    }

}
