package Modules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsTest {
    Symbols symbols;
    @BeforeEach
    void setUp() {
        symbols = new Symbols();
    }

    @Test
    void createButtons() {
        assertEquals(4, symbols.getSymbolButtonArrayList().size());
        for (int i=0; i<symbols.getSymbolButtonArrayList().size(); i++){
            assertEquals(Color.WHITE,symbols.getSymbolButtonArrayList().get(i).getBackground());
            assertNotNull(symbols.getSymbolButtonArrayList().get(i).getIcon());
        }
    }
}