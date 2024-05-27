package Modules.PPPic;

import javax.swing.*;
import java.awt.*;

public class PPPic extends JLabel {
    ImageIcon icon;

    public PPPic(String fileName){
        super();
        icon = new ImageIcon(fileName);
        setIcon(icon);
    }
}