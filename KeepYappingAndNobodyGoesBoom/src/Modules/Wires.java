package Modules;

import javax.swing.*;
import java.awt.*;

public class Wires {
    public JPanel createWireModule(){
        JPanel wireModule = new JPanel();
        wireModule.setBackground(Color.BLACK);
        wireModule.setLayout(null);
        wireModule.setBounds(0,0,1920,1080);

        return wireModule;
    }
}
