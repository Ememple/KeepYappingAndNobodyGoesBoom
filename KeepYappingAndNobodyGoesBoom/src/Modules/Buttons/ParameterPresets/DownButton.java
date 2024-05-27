package Modules.Buttons.ParameterPresets;

import Modules.Buttons.ModuleButton;
import Modules.ParameterPresets;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DownButton extends ModuleButton {
    private ParameterPresets presets;
    ImageIcon icon;
    public DownButton(ParameterPresets presets){
        super();
        this.presets = presets;
        icon = new ImageIcon("up and down buttons/downButton");
        setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
