package Modules;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Module extends JPanel {
    private Random random;
    public State state;
    public enum State{ //upravit názvy :skull:
        SUCCsesful,
        UNSLOVED,
        unSUCCsesful
    }

    public Module() {
        super();
        this.random = new Random();
        state = State.UNSLOVED;
        setBorder(BorderFactory.createLineBorder(Color.BLACK,10,false));
    }

    public Random getRandom() {
        return random;
    }

    public void createModule(){
    }

    public void disable(){
        for (int i = 0; i < getComponents().length; i++) {
            getComponent(i).setEnabled(false);
        }
    }
}
