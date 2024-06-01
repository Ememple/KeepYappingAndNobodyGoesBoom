package Frames;

import HelpClasses.FilePath;
import javax.swing.*;
import java.io.IOException;

/**
 * The type Win screen.
 */
public class WinScreen extends JFrame {
    /**
     * creates win screen
     */
    public WinScreen(){
        try {
            JPanel jPanel = new JPanel();
            ImageIcon imageIcon = FilePath.imageIcon("/winSeal.png");
            ImageIcon image = FilePath.imageIcon("/winSealIcon.png");
            JLabel label = new JLabel(imageIcon);
            jPanel.add(label);
            this.add(jPanel);
            this.pack();
            this.setIconImage(image.getImage());
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
