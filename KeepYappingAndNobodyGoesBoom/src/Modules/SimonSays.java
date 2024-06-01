package Modules;

import Frames.Bomb;
import Modules.Buttons.SimonSaysButtons.ColoredButton;
import Modules.Labels.SimonSaysLabels.Led;

import java.awt.*;
import java.io.IOException;

public class SimonSays extends Module{
    private Led led;
    private ColoredButton blue, red, green, yellow;
    private ColoredButton temporary;
    private int stage;

    public SimonSays(Bomb bomb) throws IOException {
        super(bomb);
        stage = 0;
        temporary = new ColoredButton(this, null, null);
        setLayout(new GridBagLayout());
        addColoredButtons();
        addLed();
        setVisible(true);
    }

    /**
     * Creates colored buttons.
     */
    public void addColoredButtons(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;
        constraints.gridy = 0;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.weightx = 1;
        constraints.weighty = 1;

        blue = new ColoredButton(this, new Color(0, 8, 113, 255), "blue");
        add(blue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;

        red = new ColoredButton(this, new Color(155, 0, 0), "red");
        add(red, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;

        green = new ColoredButton(this, new Color(1, 100, 19), "green");
        add(green, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;

        yellow = new ColoredButton(this, new Color(164, 162, 2), "yellow");
        add(yellow, constraints);
    }

    /**
     * Adds a Led into the module.
     * @throws IOException
     */
    public void addLed() throws IOException {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 3;
        constraints.gridy =0;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.weightx = 1;
        constraints.weighty = 1;

        led = new Led(this);
        add(led, constraints);
    }

    /**
     * Selects a random colored button.
     * @return
     */
    public ColoredButton randomButton(){
        return switch (getRandom().nextInt(0,4)){
            case 0 -> blue;
            case 1 -> red;
            case 2 -> green;
            case 3 -> yellow;
            default -> null;
        };
    }

    public Led getLed() {
        return led;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public ColoredButton getTemporary() {
        return temporary;
    }

    public void setTemporary(ColoredButton temporary) {
        this.temporary = temporary;
    }

    public ColoredButton getBlue() {
        return blue;
    }

    public ColoredButton getRed() {
        return red;
    }

    public ColoredButton getGreen() {
        return green;
    }

    public ColoredButton getYellow() {
        return yellow;
    }
}
