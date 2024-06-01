package Tests;


import HelpClasses.FilePath;

import javax.swing.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePathTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void imageIcon() {
        try {
            ImageIcon icon = FilePath.imageIcon("/LEDon.png");
            String toString = icon.toString();
            assertEquals(toString, icon.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void textFile() {
        try {
            String line = FilePath.textFile("/passwords.txt").readLine();
            assertEquals("about", line);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}