package Modules;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VerticalWiresTest {
    VerticalWires verticalWires;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        try {
            verticalWires = new VerticalWires();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @org.junit.jupiter.api.Test
    void createWires() {
        for (int i=0; i<verticalWires.getVerticalWireButtons().size(); i++){
            assertNotNull(verticalWires.getVerticalWireButtons().get(i));
            assertNotNull(verticalWires.getVerticalWireButtons().get(i).getBackground());
        }
    }
}