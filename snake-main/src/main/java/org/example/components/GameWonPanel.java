package org.example.components;

import org.example.components.Text.HeaderText;
import org.example.components.Text.NormalText;

import javax.swing.*;

public class GameWonPanel extends GameOverlayPanel{
    Runnable restartGame;
    private final NormalText time;

    GameWonPanel(){
        OverlayContentContainer contentContainer = new OverlayContentContainer();

        HeaderText headerText = new HeaderText("You Won");
        time = new NormalText("Elapsed time: 0");

        JButton tryAgainBtn = new JButton();
        tryAgainBtn.setText("Try Again");
        tryAgainBtn.addActionListener(e -> {
            doGameOver();
        });

        JButton chooseDifficultyBtn = new JButton();
        chooseDifficultyBtn.setText("Choose Difficulty Level");
        chooseDifficultyBtn.addActionListener(e -> doRestartDifficulty());

        contentContainer.add(headerText);
        contentContainer.add(time);
        contentContainer.add(tryAgainBtn);
        contentContainer.add(chooseDifficultyBtn);
        add(contentContainer);
    }

    public void showPanel(Runnable restartGame){
        this.restartGame = restartGame;

        // this needs to be added here since the GameOver panel is final
        double elapsedTime = Stopwatch.getElapsedTimeSeconds();
        time.setText("Elapsed time: " + elapsedTime + " seconds");  // end screen elapsed time text

        setVisible(true);
    }

    public void doGameOver(){
        setVisible(false); //hides panel
        restartGame.run();
    }

    public void doRestartDifficulty(){
        new DifficultyFrame();
    }
}
