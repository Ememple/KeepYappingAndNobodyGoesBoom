package Modules.Buttons.SubmitButtons;

import Modules.Buttons.ModuleButton;

import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class SubmitButton extends ModuleButton {

    public SubmitButton(){
        super();
        setText("Submit");
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e){}
}
