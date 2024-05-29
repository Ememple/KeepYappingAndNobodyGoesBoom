package Modules.Buttons.SubmitButtons;

import Modules.Buttons.ModuleButton;
import Modules.ParameterPresets;

import java.awt.event.ActionEvent;

public class ParameterPresetsSB extends ModuleButton {
    ParameterPresets presets;
    public ParameterPresetsSB(ParameterPresets presets){
        super();
        this.presets = presets;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        boolean correct = true;
    }
}
