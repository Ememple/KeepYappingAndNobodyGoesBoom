package Modules.Labels.SimonSaysLabels;

import HelpClasses.FilePath;
import Modules.SimonSays;

import javax.swing.*;
import java.io.IOException;

public class Led extends JLabel {
    private SimonSays simon;
    private ImageIcon icon;
    private String color;

    public Led(SimonSays simon) throws IOException {
        super();
        this.simon = simon;
        icon = FilePath.imageIcon(randomColor());
        setIcon(icon);
        setVisible(true);
    }

    public String randomColor() throws IOException {
        String color = "/LEDS/";
        switch(simon.getRandom().nextInt(0,4)){
            case 0 -> {
                color += "blue.png";
                this.color = "blue";
            }
            case 1 -> {
                color += "red.png";
                this.color = "red";
            }
            case 2 -> {
                color += "green.png";
                this.color = "green";
            }
            case 3 -> {
                color += "yellow.png";
                this.color = "yellow";
            }
        }
        return color;
    }

    public String getColor() {
        return color;
    }
}
