package Modules;

import javax.swing.*;
import java.awt.*;

public class Button extends Module {
    private JButton button;
    private JPanel indicator;

    public Button(){
        super();
        button = new JButton();
        indicator = new JPanel();
        button();
        setVisible(true);
    }

    public void button(){
        button.setBounds(15,15, 60,60);
        indicator.setBounds(button.getWidth()+10, button.getY(), 25, 60);
        switch (getRandom().nextInt(0,3)){
            case 0->{
                button.setBackground(Color.MAGENTA);
                button.setText("HOLD");
                indicator.setBackground(Color.green);
            }
            case 1 ->{
                button.setText("DETONATE");
                button.setBackground(Color.RED);
                indicator.setBackground(Color.RED);
            }
            case 2 ->{
                button.setText("DO NOT PRESS");
                button.setBackground(Color.WHITE);
                indicator.setBackground(Color.LIGHT_GRAY);
            }
        }
        button.setVisible(true);
        indicator.setVisible(true);
    }
}
