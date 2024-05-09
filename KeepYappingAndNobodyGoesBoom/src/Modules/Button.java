package Modules;

import javax.swing.*;
import java.awt.*;

public class Button extends Module {
    private JButton button;

    public Button(){
        super();
        button = new JButton();
        button();
    }

    public void button(){
        switch (getRandom().nextInt(0,3)){
            case 0->{
                button.setBackground(Color.MAGENTA);
                button.setText("HOLD");
            }
            case 1 ->{
                button.setText("DETONATE");
                button.setBackground(Color.RED);
            }
            case 2 ->{
                button.setText("DO NOT PRESS");
                button.setBackground(Color.WHITE);
            }
        }
        button.setBounds(20, 20, 40, 40);
        setVisible(true);
    }
}
