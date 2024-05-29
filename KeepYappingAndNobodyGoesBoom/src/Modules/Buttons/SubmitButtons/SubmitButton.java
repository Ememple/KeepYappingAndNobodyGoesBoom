package Modules.Buttons.SubmitButtons;

import Modules.Buttons.ModuleButton;

import java.awt.event.ActionEvent;

public abstract class SubmitButton extends ModuleButton {

    public SubmitButton(){
        super();
        //this.password = password;
        //this.addActionListener(this);
        setText("Submit");
    }

    @Override
    public void actionPerformed(ActionEvent e){}
}
