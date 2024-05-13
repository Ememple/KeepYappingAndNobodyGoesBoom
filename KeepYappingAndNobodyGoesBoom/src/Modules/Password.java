package Modules;

import Modules.PasswordButtons.DownButton;
import Modules.PasswordButtons.UpButton;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Password extends Module{
    private UpButton upButton;
    private DownButton downButton;
    private int rows = 4;
    private int columns = 5;
    private char[][] chars;
    private String[] passwords;
    private String password;
    private JLabel label;

    public Password() throws IOException {
        chars = new char[rows][columns];
        passwords = new String[35];
        addIntoPasswords();
        password = passwords[getRandom().nextInt(35)];
        upButton = new UpButton();
        downButton = new DownButton();
        addIntoChars();
        setLayout(new GridLayout(3,5));
        addUpButtons();
        addCharsComponent();
        addDownButtons();
        setVisible(true);
    }

    public void addIntoPasswords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("paswords.txt"));
        for (int i = 0; i < passwords.length; i++) {
            passwords[i] = reader.readLine();
        }
    }

    public void addIntoChars(){
        for (int i = 0; i < password.length(); i++) {
            chars[i][0] = password.charAt(i);
        }

        for (int i = 0; i < rows; i++) {
            for (int ii = 1; ii < columns; ii++) {
                chars[i][ii] = (char) getRandom().nextInt(97,123);
            }
        }
    }

    public void addUpButtons(){
        for (int i = 0; i < 5; i++) {
            add(upButton);
        }
    }

    public void addCharsComponent(){
        for (int i = 0; i < 5; i++){
            add(new JLabel(String.valueOf(chars[1][getRandom().nextInt(4)])));
        }
    }

    public void addDownButtons(){
        for (int i = 0; i < 5; i++) {
            add(downButton);
        }
    }
}