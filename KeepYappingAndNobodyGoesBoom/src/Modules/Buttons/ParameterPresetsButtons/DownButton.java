package Modules.Buttons.ParameterPresetsButtons;

import Modules.Buttons.ModuleButton;
import Modules.PPContainer;
import Modules.ParameterPresets;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DownButton extends ModuleButton {
    //private ParameterPresets presets;
    private PPContainer container;
    private ImageIcon icon;
    public DownButton(PPContainer container){
        super();
        //this.presets = presets;
        this.container = container;
        icon = new ImageIcon("up and down buttons/downButton.png");
        setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        container.setNextPic();
    }
}
