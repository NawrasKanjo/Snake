package org.example.components;

import org.example.Movement;

import javax.swing.*;

public class GameFrame extends JFrame{
    public static final int CONTENT_HEIGHT = 500; // Must be divisible with GamePanel.UNIT_SIZE
    private static final int VERTICAL_MARGIN = 30; // This exists because otherwise the GamePanel will not have enough room. Not sure why.
    public static final int WINDOW_HEIGHT = CONTENT_HEIGHT + VERTICAL_MARGIN;
    public static final int WINDOW_WIDTH = 500; // Must be divisible with GamePanel.UNIT_SIZE

    public GameFrame(){
        setTitle("Wild Snake");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The program will quit if you close the window
        setResizable(false);
        setVisible(true);
        addKeyListener(new Movement());
        setLocationRelativeTo(null);
    }


    // Separate method because Game.java needs a reference to the GamePanel, and it wouldn't make sense to return it in render()
    public GamePanel addGamePanel(){
        GamePanel gamePanel = new GamePanel();
        
        add(gamePanel);
        revalidate();   //Ensure that the layout and appearance are updated
        repaint();      //Ensure that the layout and appearance are updated

        return gamePanel;
    }

}