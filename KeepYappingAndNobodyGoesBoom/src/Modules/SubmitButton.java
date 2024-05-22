package Modules;

import Frames.Bomb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SubmitButton extends JButton implements ActionListener {

    public SubmitButton(){
        super();
        //this.password = password;
        this.addActionListener(this);
        setText("Submit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
