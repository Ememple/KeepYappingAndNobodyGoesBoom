package Modules.Buttons.PasswordButtons;

import Modules.Buttons.ModuleButton;
import Modules.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DownButton extends ModuleButton {
    static ImageIcon imageIcon = new ImageIcon("downButton.png");
    Password password;
    int char_index;
    public DownButton(Password password, int char_index){
        super();
        this.password = password;
        this.char_index = char_index;
        setBackground(Color.WHITE);
        setIcon(imageIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int new_char = (password.getChars()[char_index]+1) % 5;
        password.getChars()[char_index] = new_char;
        password.getCharacters().get(char_index).setText("" + password.getPassword().charAt(new_char));
        //System.out.println("performed");
    }
}