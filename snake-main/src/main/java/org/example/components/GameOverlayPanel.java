package org.example.components;

import javax.swing.*;
import java.awt.*;

public class GameOverlayPanel extends JPanel {
    private static final Color backgroundColor = new Color(30, 30, 30, 140);

    public GameOverlayPanel(){
        setBackground(backgroundColor);
        ((FlowLayout) getLayout()).setVgap(0); //removes bad margin
        setVisible(false); //default is hidden
        setPreferredSize(new Dimension(GameFrame.WINDOW_WIDTH, GameFrame.CONTENT_HEIGHT));

        //Complicated stuff
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
    }
}
