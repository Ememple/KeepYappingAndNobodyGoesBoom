package Frames.MenuButtons;

import Frames.Bomb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlay extends JButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Bomb bomb = new Bomb();
        bomb.start();
    }

    public ButtonPlay(String text) {
        super(text);
    }
}
