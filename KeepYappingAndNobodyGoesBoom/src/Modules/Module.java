package Modules;

import Frames.Bomb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Module extends JPanel {
    private Bomb bomb;
    private Random random;
    //private boolean solved;

    public Module(Bomb bomb) {
        super();
        this.bomb = bomb;
        //solved = false;
        this.random = new Random();
        setBorder(BorderFactory.createLineBorder(Color.BLACK,10,false));
    }

    public Random getRandom() {
        return random;
    }

    public void disable(){
        for (int i = 0; i < getComponents().length; i++) {
            getComponent(i).setEnabled(false);
        }
        setEnabled(false);
        //solved = true;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    /*public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }*/
}
