package Frames.MenuButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ButtonManual extends JButton implements ActionListener{

     @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File manualPDF = new File("KeepYappingAndNobodyGoesBoom/src/res/Manual.pdf");
            Desktop.getDesktop().open(manualPDF);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ButtonManual(String text) {
        super(text);
    }
}
