package org.example.components;

import org.example.Apple;
import org.example.Settings;
import org.example.Snake;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    public static final int UNIT_SIZE = 25;    //Unit size of each square

    public static final int GRID_WIDTH = GameFrame.WINDOW_WIDTH / UNIT_SIZE; // Not in pixels, measured in units
    public static final int GRID_HEIGHT = GameFrame.CONTENT_HEIGHT / UNIT_SIZE; // Not in pixels, measured in units

    private final GameOverPanel gameOverPanel = new GameOverPanel();
    private final GameWonPanel gameWonPanel = new GameWonPanel();
    private Snake snake;
    private Apple apple;

    public GamePanel() {
        ((FlowLayout) getLayout()).setVgap(0); //removes bad margin
        setOpaque(true);
        setPreferredSize(new Dimension(GameFrame.WINDOW_WIDTH, GameFrame.CONTENT_HEIGHT));
        setBackground(Settings.getInstance().gamePanelBackground);
        add(gameOverPanel);
        add(gameWonPanel);
        setDoubleBuffered(true); // Reduces flickering issues
    }

    public void initialize(Snake snake, Apple apple) {
        this.snake = snake;
        this.apple = apple;
    }

    // Called EVERY TIME JPanel "paints"
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        drawGridLines(graphics);

        if (apple != null && snake != null) {
            apple.draw(graphics);
            snake.draw(graphics);
        }
    }

    private void drawGridLines(Graphics graphics) {
        graphics.setColor(Settings.getInstance().gamePanelLineColor);

        // draws vertical lines
        for (int i = 1; i < GRID_WIDTH; i++) {
            graphics.drawLine(unitToPx(i), 0, unitToPx(i), GameFrame.CONTENT_HEIGHT);
        }

        // draws horizontal lines
        for (int i = 1; i < GRID_HEIGHT; i++) {
            graphics.drawLine(0, unitToPx(i), GameFrame.WINDOW_WIDTH, unitToPx(i));
        }
    }

    public void showGameWon(Runnable restartGame) {
        gameWonPanel.showPanel(restartGame);
        repaint();
    }

    public void showGameOver(Runnable restartGame) {
        gameOverPanel.showPanel(restartGame);
        repaint();
    }

    //========== USED BY COMPONENTS ==========

    public static int unitToPx(int units) {        //Unit to Pixels
        return units * UNIT_SIZE;
    }

    public boolean isLocationWithinBounds(int x, int y) {
        return (x < GRID_WIDTH) && (x >= 0) &&
                (y < GRID_HEIGHT) && (y >= 0);
    }

    public boolean isSpaceEmpty(int x, int y) {
        boolean snakeOccupiesSpace = snake.doesOccupySpace(x, y);
        boolean appleOccupiesSpace =
                (apple.getX() == x) &&
                (apple.getY() == y);

        return !(snakeOccupiesSpace || appleOccupiesSpace);
    }

    public static void fillRect(Graphics graphics, int x, int y, Color color) {
        graphics.setColor(color);
        graphics.fillRect(unitToPx(x), unitToPx(y), UNIT_SIZE, UNIT_SIZE);
    }

    public boolean snakeOccupiesWholeBoard() {
        return snake.getLength() >= GRID_HEIGHT * GRID_WIDTH;
    }

}
