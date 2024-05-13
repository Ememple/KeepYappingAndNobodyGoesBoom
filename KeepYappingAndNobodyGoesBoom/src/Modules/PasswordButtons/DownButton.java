package Modules.PasswordButtons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownButton extends JButton implements ActionListener {
    public DownButton(){
        setIcon((Icon) new ImageIcon("downButton.txt").getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
