package Frames;

import Modules.*;
import Modules.Button;

import java.awt.*;
import java.util.Random;

public class Bomb extends Frame {

    public Bomb(){
        super();
        setLayout(new GridLayout(2,3,10,10));
        setVisible(true);
    }

    public void start(){

        for (int i = 0; i < 6; i++) {
            Component test = randomModule();
            if (test != null) continue;
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
