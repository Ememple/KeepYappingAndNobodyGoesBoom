package Modules;

import Modules.PasswordButtons.DownButton;
import Modules.PasswordButtons.UpButton;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Password extends Module{
    private UpButton upButton;
    private DownButton downButton;
    private int rows = 5;
    private int columns = 4;
    private char[][] chars;
    private String[] passwords;
    private String password;

    public Password() throws IOException {
        chars = new char[rows][columns];
        passwords = new String[35];
        addIntoPasswords();
        password = passwords[getRandom().nextInt(35)];
        addIntoChars();
        setLayout(new GridLayout(2,3));
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

        for (int i = 0; i < columns; i++) {
            for (int ii = 1; ii < rows; ii++) {
                chars[i][ii] = (char) getRandom().nextInt(97,123);
            }
        }
    }
}