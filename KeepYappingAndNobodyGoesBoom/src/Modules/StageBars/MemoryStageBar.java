package Modules.StageBars;

import javax.swing.*;
import java.awt.*;

public class MemoryStageBar extends JProgressBar {
    /**
     * A stage bar indicating progress.
     */
    public MemoryStageBar(){
        super(0,5);
        setValue(0);
        setForeground(Color.GREEN);
        setBackground(Color.RED);
        setOrientation(SwingConstants.VERTICAL);
        setVisible(true);
    }
}
