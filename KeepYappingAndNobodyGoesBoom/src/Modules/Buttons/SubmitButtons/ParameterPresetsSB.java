package Modules.Buttons.SubmitButtons;

import Frames.Bomb;
import Modules.PPContainer;
import Modules.ParameterPresets;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ParameterPresetsSB extends SubmitButton {
    ParameterPresets presets;
    public ParameterPresetsSB(ParameterPresets presets){
        super();
        this.presets = presets;
        setText("Submit");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        boolean correct = true;
        for(Component tile : presets.getComponents()){
            if (tile instanceof PPContainer){
                if (!(((PPContainer) tile).getPic().getFileName().equals(presets.getCombinations().get(Integer.parseInt(presets.getCombination().getText()))))){
                    correct = false;
                    Bomb.strikePlus();
                    break;
                }
            }
        }
        if (!correct){
            presets.disable();
        }
    }
}