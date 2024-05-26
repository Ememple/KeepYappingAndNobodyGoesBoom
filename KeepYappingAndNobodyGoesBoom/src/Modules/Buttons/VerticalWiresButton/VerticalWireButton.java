package Modules.Buttons.VerticalWiresButton;

import javax.swing.*;

public class VerticalWireButton extends JButton {
    private int value;
    private boolean led;
    private boolean star;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isLed() {
        return led;
    }

    public void setLed(boolean led) {
        this.led = led;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public VerticalWireButton() {
    }
}
