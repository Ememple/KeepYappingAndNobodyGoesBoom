package Frames;

import Modules.*;
import Modules.Button;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bomb extends Frame {

    public Bomb(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
        setResizable(true);
        setLayout(new GridLayout(2,3,5,5));
        setVisible(true);
    }

    public void start(){
        for (int i = 0; i < 6; i++) {
            add(randomModule());
        }
        setVisible(true);
    }

    public Component randomModule(){
        Random random = new Random();
        switch (random.nextInt(0,5)+1){
            case 1 -> {
                //dráty
                return new Wires();
            }
            case 2 -> {
                //tlačítko
                return new Button();
            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }

        return null;
    }
}
