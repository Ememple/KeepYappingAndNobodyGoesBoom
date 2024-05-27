package Modules.Buttons.ParameterPresets;

import Modules.Buttons.ModuleButton;
import Modules.ParameterPresets;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpButton extends ModuleButton {
    private ParameterPresets presets;
    private ImageIcon icon;
    public UpButton(ParameterPresets presets){
        super();
        this.presets = presets;
        icon = new ImageIcon("up and down buttons/upButton.png");
        setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
