package Modules.Buttons.SimonSaysButtons;

import Frames.Bomb;
import Modules.SimonSays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static javax.swing.text.StyleConstants.Background;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredButtonTest {

    @Test
    void color() {
        try {
            SimonSays simon = new SimonSays(new Bomb());
            ColoredButton button = new ColoredButton(simon, Color.YELLOW, "yellow");
            assertEquals(Color.YELLOW, button.getBackground());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}