package Frames;

import Modules.*;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Bomb extends Frame {
    public void start(){
        setBackground(Color.LIGHT_GRAY);
        setSize(1000,1000);
        setLayout(new GridLayout(2,3, 10, 10));
        BombTimer bombTimer = new BombTimer();

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
                return new Wires().createWireModule();
            }
            case 2 -> {
                //heslo
                try {
                    return new Password();
                } catch (IOException ignored) {}
            }
            case 3 -> {
                //modul 3
            }
            case 4 -> {
                //modul 4
            }
            case 5 -> {
                //modul 5
            }
        }
        return null;
    }
}
