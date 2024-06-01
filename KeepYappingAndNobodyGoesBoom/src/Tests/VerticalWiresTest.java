package Tests;

import Frames.Bomb;
import Modules.VerticalWires;

import java.io.IOException;

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