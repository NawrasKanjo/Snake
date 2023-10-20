package org.example.components;

import org.example.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame implements ActionListener {

    private final JFrame difficultyWindow = new JFrame();
    //========== Creating the Difficulty Frame components ==========
    private final JButton easyBtn = new JButton("Easy");
    private final JButton mediumBtn = new JButton("Medium");
    private final JButton hardBtn = new JButton("Hard");

    //========== Defining the Difficulty Frame components(constructors) ==========
    public DifficultyFrame(){
        easyBtn.setBounds(225,100,150,50);
        mediumBtn.setBounds(225,250,150,50);
        hardBtn.setBounds(225,400,150,50);

        easyBtn.addActionListener(this);
        mediumBtn.addActionListener(this);
        hardBtn.addActionListener(this);

        difficultyWindow.setSize(600,600);
        difficultyWindow.getContentPane().setBackground(Color.decode("#3333"));
        difficultyWindow.setLayout(null);
        difficultyWindow.setVisible(true);
        difficultyWindow.setLocationRelativeTo(null);
        difficultyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        difficultyWindow.add(easyBtn);
        difficultyWindow.add(mediumBtn);
        difficultyWindow.add(hardBtn);
    }

    //========== Choosing the difficulty level where each level will set the snake at a certain speed ==========
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyBtn){
            difficultyWindow.dispose();
            Game.setTickSpeed(200);
        }else if (e.getSource() == mediumBtn){
            difficultyWindow.dispose();
            Game.setTickSpeed(100);
        }else if (e.getSource() == hardBtn){
            difficultyWindow.dispose();
            Game.setTickSpeed(50);
        }
        //========== After choosing the difficulty level, the game will start ==========
        Game game = new Game();
        game.start();
    }
}
