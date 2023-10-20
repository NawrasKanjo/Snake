package org.example.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeFrame extends JFrame implements ActionListener {
    //Frames
    private final JFrame welcomeWindow = new JFrame();

    //========== Creating the Welcome Frame components (Buttons) ==========
    private final JButton difficultyLevelBtn = new JButton("Difficulty Level");
    private final JButton customizationBtn = new JButton(("Customization"));

    //========== Defining the interface components ==========
    public WelcomeFrame(){
        welcomeWindow.setSize(600,600);
        welcomeWindow.getContentPane().setBackground(Color.decode("#333333"));
        welcomeWindow.setLayout(null);
        welcomeWindow.setLocationRelativeTo(null);
        welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeMessageLabel = new JLabel("Welcome to Wild Snake Game");
        welcomeMessageLabel.setForeground(Color.white);
        welcomeMessageLabel.setBounds(200,50,400,150);
        difficultyLevelBtn.setBounds(170,250,250,50);
        customizationBtn.setBounds(170,150,250,50);

        difficultyLevelBtn.addActionListener(this);
        customizationBtn.addActionListener(this);

        welcomeWindow.add(difficultyLevelBtn);
        welcomeWindow.add(customizationBtn);
        welcomeWindow.add(welcomeMessageLabel);
    }

    public void showFrame(){
        welcomeWindow.setVisible(true);
    }

    //========== Either moving Difficulty frame or to Customization frame ==========
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficultyLevelBtn){
            welcomeWindow.dispose();
            new DifficultyFrame(); //creates and displays frame
        }
        else if (e.getSource() == customizationBtn){
            welcomeWindow.dispose();
            new CustomizationFrame(); //creates and displays frame
        }
    }
}
