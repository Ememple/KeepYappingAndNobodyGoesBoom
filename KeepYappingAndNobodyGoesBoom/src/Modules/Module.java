package Modules;

import Frames.Bomb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Module extends JPanel {
    private Bomb bomb;
    private Random random;

    public Module(Bomb bomb) {
        super();
        this.bomb = bomb;
        this.random = new Random();
        setBorder(BorderFactory.createLineBorder(Color.BLACK,10,false));
    }

    public Random getRandom() {
        return random;
    }

    public void disableModule(){
        for (int i = 0; i < getComponents().length; i++) {
            getComponent(i).setEnabled(false);
        }
        setEnabled(false);
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }
}
