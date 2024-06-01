package Modules;

import Frames.Bomb;
import Modules.Buttons.PasswordButtons.DownButton;
import Modules.Buttons.SubmitButtons.PasswordSB;
import Modules.Buttons.PasswordButtons.UpButton;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import HelpClasses.*;

import java.io.IOException;
import java.util.ArrayList;

public class Password extends Module {
    private int length;
    private int[] chars;
    private String[] passwords;
    private String password;
    ArrayList<JLabel> characters;

    public Password(Bomb bomb) throws IOException {
        super(bomb);
        length = 5;
        chars = new int[length];
        passwords = new String[35];
        addIntoPasswords();
        password = passwords[getRandom().nextInt(35)];
        characters = new ArrayList<>();
        addIntoChars();
        setLayout(new GridBagLayout());
        addUpButtons();
        addCharsComponent();
        addDownButtons();
        addSubmitButton();
        setVisible(true);
    }

    /**
     * Reads all valid passwords from an external file.
     * @throws IOException
     */
    public void addIntoPasswords() throws IOException {
        BufferedReader reader = FilePath.textFile("/passwords.txt");
        for (int i = 0; i < passwords.length; i++) {
            passwords[i] = reader.readLine();
        }
    }

    /**
     * Creates a collection of char indexes.
     */
    public void addIntoChars(){
        for (int i = 0; i < 5; i++) {
            chars[i] = getRandom().nextInt(5);
        }
    }

    /**
     * Adds a button for changing the character.
     * @throws IOException
     */
    public void addUpButtons() throws IOException {
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

    /**
     * Adds characters into the module.
     */
    public void addCharsComponent(){
        for (int i = 0; i < 5; i++){
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = i;
            constraints.gridy = 1;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.VERTICAL;

            constraints.weightx = 1;
            constraints.weighty = 1;
            JLabel character = new JLabel(STR."\{password.charAt(chars[i])}");
            character.setFont(new Font("monospaced", Font.PLAIN, 30));
            characters.add(character);
            add(characters.get(i), constraints);
        }
    }

    /**
     * Same as the previous method.
     */
    public void addDownButtons() throws IOException {
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

    /**
     * Adds a submit button.
     */
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

    public int[] getChars() {
        return chars;
    }

    public ArrayList<JLabel> getCharacters() {
        return characters;
    }

    public String getPassword() {
        return password;
    }

}