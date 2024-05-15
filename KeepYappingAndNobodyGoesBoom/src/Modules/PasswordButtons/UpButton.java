package Modules.PasswordButtons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpButton extends JButton implements ActionListener {
    public UpButton(){
        setIcon((Icon) new ImageIcon("upButton.txt").getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
