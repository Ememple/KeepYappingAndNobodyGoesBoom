package Modules.Buttons.ParameterPresetsButtons;

import Modules.Buttons.ModuleButton;
import Modules.PPContainer;
import Modules.ParameterPresets;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpButton extends ModuleButton {
    //private ParameterPresets presets;
    private PPContainer container;
    private ImageIcon icon;
    public UpButton(PPContainer container){
        super();
        //this.presets = presets;
        this.container = container;
        icon = new ImageIcon("up and down buttons/upButton.png");
        setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        container.setPreviousPic();
    }


}
