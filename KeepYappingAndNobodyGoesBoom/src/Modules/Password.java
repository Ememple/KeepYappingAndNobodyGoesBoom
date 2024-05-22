package Modules;

import Modules.PasswordButtons.DownButton;
import Modules.PasswordButtons.PasswordSB;
import Modules.PasswordButtons.UpButton;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Password extends Module{
    private int length;
    private int[] chars;
    private String[] passwords;
    private String password;
    ArrayList<JLabel> characters;
    LayoutManager layout;

    public Password() throws IOException {
        super();
        length = 5;
        chars = new int[length];
        passwords = new String[35];
        addIntoPasswords();
        password = passwords[getRandom().nextInt(35)];
        characters = new ArrayList<>();
        addIntoChars();
        layout = new GridBagLayout();
        setLayout(layout);
        addUpButtons();
        addCharsComponent();
        addDownButtons();
        addSubmitButton();
        setVisible(true);
    }

    public void addIntoPasswords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"));
        for (int i = 0; i < passwords.length; i++) {
            passwords[i] = reader.readLine();
        }
    }

    public void addIntoChars(){
        for (int i = 0; i < 5; i++) {
            chars[i] = getRandom().nextInt(5);
        }
    }

    public void addUpButtons(){
        for (int i = 0; i < 5; i++) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = i;
            constraints.gridy = 0;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;

            constraints.weightx = 1;
            constraints.weighty = 1;
            add(new UpButton(this, i), constraints);
        }
    }

    public void addCharsComponent(){
        for (int i = 0; i < 5; i++){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = i;
            constraints.gridy = 1;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;

            constraints.weightx = 1;
            constraints.weighty = 1;
            characters.add(new JLabel("" + password.charAt(chars[i])));
            add(characters.get(i), constraints);
        }
    }

    public void addDownButtons(){
        for (int i = 0; i < 5; i++) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = i;
            constraints.gridy = 2;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;

            constraints.weightx = 1;
            constraints.weighty = 1;
            add(new DownButton(this, i), constraints);
        }
    }

    public void addSubmitButton(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;

        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.weightx = 1;
        constraints.weighty = 0.5;
        add(new PasswordSB(this), constraints);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getChars() {
        return chars;
    }

    public void setChars(int[] chars) {
        this.chars = chars;
    }

    public ArrayList<JLabel> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<JLabel> characters) {
        this.characters = characters;
    }

    public String[] getPasswords() {
        return passwords;
    }

    public void setPasswords(String[] passwords) {
        this.passwords = passwords;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}