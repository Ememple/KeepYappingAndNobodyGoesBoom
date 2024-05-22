package Modules.PasswordButtons;

import Modules.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownButton extends JButton implements ActionListener {
    static ImageIcon imageIcon = new ImageIcon("downButton.png");
    Password password;
    int char_index;
    public DownButton(Password password, int char_index){
        super();
        this.password = password;
        this.char_index = char_index;
        setBackground(Color.WHITE);
        setIcon(imageIcon);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int new_char = (password.getChars()[char_index]+1) % 5;
        password.getChars()[char_index] = new_char;
        password.getCharacters().get(char_index).setText("" + password.getPassword().charAt(new_char));
        //System.out.println("performed");
    }
}
