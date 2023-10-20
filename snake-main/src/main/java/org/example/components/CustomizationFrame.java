package org.example.components;

import org.example.Settings;
import org.example.SnakeColorSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomizationFrame implements ActionListener {
    private static final Color BACKGROUND_COLOR = Color.decode("#3333");

    //Frames
    private final JFrame customizationFrame = new JFrame();

    //========== Creating the Customization frame components (Buttons) ==========
    private final JButton staticColorsBtn = new JButton("Static Colors");
    private final JButton randomColorsBtn = new JButton("Random");
    private final JButton invisibleOptionBtn = new JButton("Invisible");

    //========== Defining the Customization frame components(constructor) ==========
    public CustomizationFrame() {
        staticColorsBtn.setBounds(225, 100, 150, 50);
        randomColorsBtn.setBounds(225, 250, 150, 50);
        invisibleOptionBtn.setBounds(225, 400, 150, 50);

        staticColorsBtn.addActionListener(this);
        randomColorsBtn.addActionListener(this);
        invisibleOptionBtn.addActionListener(this);

        customizationFrame.setSize(600, 600);
        customizationFrame.getContentPane().setBackground(BACKGROUND_COLOR);
        customizationFrame.setLayout(null);
        customizationFrame.setVisible(true);
        customizationFrame.setLocationRelativeTo(null);
        customizationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customizationFrame.add(staticColorsBtn);
        customizationFrame.add(randomColorsBtn);
        customizationFrame.add(invisibleOptionBtn);
    }

    //========== Three different buttons to set the snake's colour ==========
    @Override
    public void actionPerformed(ActionEvent e) {
        //========== Choosing the static colour option will take the user to another Customization colour frame  ==========
        if (e.getSource() == staticColorsBtn) {
            customizationFrame.dispose();
            new StaticColorsFrame();
        }

        //========== Choosing random colour will take the user to the difficulty frame==========
        if (e.getSource() == randomColorsBtn) {
            SnakeColorSettings.isRandomColor = true;
            customizationFrame.dispose();
            new DifficultyFrame();
        }

        //========== Choosing invisible colour(Colour the match the background) will take the user to the difficulty frame==========
        if (e.getSource() == invisibleOptionBtn) {
            Settings settings = Settings.getInstance();
            SnakeColorSettings.setColors(settings.gamePanelBackground, settings.gamePanelBackground);
            customizationFrame.dispose();
            new DifficultyFrame();
        }
    }


}
