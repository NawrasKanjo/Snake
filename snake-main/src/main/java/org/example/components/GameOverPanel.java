package org.example.components;

import org.example.components.Text.HeaderText;
import org.example.components.Text.NormalText;

import javax.swing.*;

public class GameOverPanel extends GameOverlayPanel {
    private Runnable restartGame;
    private NormalText elapsedTimeDisplay;

    GameOverPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("Game Over");
        elapsedTimeDisplay = new NormalText("Elapsed time: "); // Initial value only

        JButton tryAgainBtn = new JButton();
        tryAgainBtn.setText("Try Again");
        tryAgainBtn.addActionListener(e -> doGameOver());  //e is an action event. Choosing try again, the game will restart

        JButton chooseDifficultyBtn = new JButton();
        chooseDifficultyBtn.setText("Choose Difficulty Level");
        chooseDifficultyBtn.addActionListener(e -> doRestartDifficulty()); //e is an action event. Choosing restart difficulty

        contentContainer.add(headerText);
        contentContainer.add(elapsedTimeDisplay);
        contentContainer.add(tryAgainBtn);
        contentContainer.add(chooseDifficultyBtn);
        add(contentContainer);
    }

    public void showPanel(Runnable restartGame){
        this.restartGame = restartGame;

        double elapsedTime = Stopwatch.getElapsedTimeSeconds();
        elapsedTimeDisplay.setText("Elapsed time: " + elapsedTime + " seconds");  // end screen elapsed time text

        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false);
        restartGame.run();
    }
    public void doRestartDifficulty(){
        new DifficultyFrame();
    }
}
