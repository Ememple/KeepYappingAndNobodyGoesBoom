package Modules.Buttons.MemoryButtons;

import Frames.Bomb;
import Modules.Memory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeNumberButtonTest {

    @Test
    void nextStage() {
        Memory memory = new Memory(new Bomb());
        ChangeNumberButton button = new ChangeNumberButton(memory, 1, 0);
        button.nextStage();
        assertEquals(2, memory.getStage());
    }

    @Test
    void resetStage() {
        Memory memory = new Memory(new Bomb());
        ChangeNumberButton button = new ChangeNumberButton(memory, 1, 0);
        button.nextStage();
        button.nextStage();
        button.resetStage();
        assertEquals(1, memory.getStage());
    }
}