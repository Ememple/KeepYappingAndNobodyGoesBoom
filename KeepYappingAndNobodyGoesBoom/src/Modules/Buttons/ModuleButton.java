package Modules.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ModuleButton extends JButton implements ActionListener {
    public ModuleButton(){
        super();
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
