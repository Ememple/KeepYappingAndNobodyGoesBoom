package Frames.MenuButtons;

import Frames.Bomb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonPlay extends JButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Bomb bomb = new Bomb();
        try {
            bomb.start();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ButtonPlay(String text) {
        super(text);
    }
}
