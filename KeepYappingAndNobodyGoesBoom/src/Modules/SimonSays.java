package Modules;

import Modules.Buttons.SimonSaysButtons.ColoredButton;

import java.awt.*;
import java.io.IOException;

public class SimonSays extends Module{
    private Led led;
    private ColoredButton blue, red, green, yellow;
    private ColoredButton temporary;
    private int stage;

    public SimonSays() throws IOException {
        super();
        stage = 0;
        temporary = new ColoredButton(this, null, null);
        setLayout(new GridBagLayout());
        addColoredButtons();
        addLed();
        setVisible(true);
    }

    public void addColoredButtons(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;
        constraints.gridy = 1;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.weightx = 2;
        constraints.weighty = 2;

        blue = new ColoredButton(this, Color.LIGHT_GRAY, "blue");
        add(blue, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;

        red = new ColoredButton(this, Color.LIGHT_GRAY, "red");
        add(red, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;

        green = new ColoredButton(this, Color.LIGHT_GRAY, "green");
        add(green, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;

        yellow = new ColoredButton(this, Color.LIGHT_GRAY, "yellow");
        add(yellow, constraints);
    }

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
