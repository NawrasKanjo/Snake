package org.example.components.Text;

import javax.swing.*;
import java.awt.*;

public class HeaderText extends JTextField {
    private static final Font myFont = new Font("SansSerif", Font.BOLD, 30);

    public HeaderText(String text){
        setText(text);
        setFont(myFont);
        setOpaque(false); //no background
        setBorder(null);
        setForeground(Color.decode("#eeeeee"));
    }
}
