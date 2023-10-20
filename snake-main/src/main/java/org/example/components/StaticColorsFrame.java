package org.example.components;

import org.example.SnakeColorSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaticColorsFrame implements ActionListener {

    //Frame
    private final JFrame staticColorFrame = new JFrame();

    //========== Creating the Static colours frame components (Buttons) ==========
    private final JButton red = new JButton("Red");
    private final JButton blue = new JButton("Blue");
    private final JButton green = new JButton("Green");
    private final JButton yellow = new JButton("Yellow");
    private final JButton white = new JButton("White");
    private final JButton purple = new JButton("Purple");

    //========== Defining the Static Colours frame components(constructors) ==========
    public StaticColorsFrame(){
        red.setBounds(125,100,150,50);
        blue.setBounds(125,250,150,50);
        green.setBounds(125,400,150,50);
        yellow.setBounds(325,100,150,50);
        white.setBounds(325,250,150,50);
        purple.setBounds(325,400,150,50);

        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        white.addActionListener(this);
        purple.addActionListener(this);

        staticColorFrame.setSize(600,600);
        staticColorFrame.getContentPane().setBackground(Color.decode("#3333"));
        staticColorFrame.setLayout(null);
        staticColorFrame.setVisible(true);
        staticColorFrame.setLocationRelativeTo(null);
        staticColorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        staticColorFrame.add(red);
        staticColorFrame.add(blue);
        staticColorFrame.add(green);
        staticColorFrame.add(yellow);
        staticColorFrame.add(white);
        staticColorFrame.add(purple);
    }

    //========== The user can choose between six different colours for the snake==========
    @Override
    public void actionPerformed(ActionEvent e) {
    Color headColor = null;
    Color bodyColor = null;

        if(e.getSource() == red){
           headColor = Color.decode("#FF0000");
           bodyColor = Color.decode("#880808");
        }

        else if(e.getSource() == blue){
            headColor = Color.decode("#0096FF");
            bodyColor = Color.decode("#0096FF");
        }

        else if(e.getSource() == green){
            headColor = Color.decode("#50C878");
            bodyColor = Color.decode("#7CFC00");
        }

        else if(e.getSource() == yellow){
            headColor = Color.decode("#FFC000");
            bodyColor = Color.decode("#FCF55F");
        }

        else if(e.getSource() == white){
            headColor = Color.decode("#FFFFF0");
            bodyColor = Color.decode("#F0EAD6");
        }

        else if(e.getSource() == purple){
            headColor = Color.decode("#BF40BF");
            bodyColor = Color.decode("#702963");
        }

        SnakeColorSettings.setColors(headColor, bodyColor);

        //========== After choosing the snake colour, the user will be moved to the difficulty level frame ==========
        new DifficultyFrame(); //creates and displays difficulty frame
        staticColorFrame.dispose();
    }
}

