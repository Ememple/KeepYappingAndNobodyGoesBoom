package Modules;

import javax.swing.*;
import java.util.Random;

public abstract class Module extends JPanel {
    private Random random;

    public Module() {
        super();
        this.random = new Random();
    }

    public Random getRandom() {
        return random;
    }
}
