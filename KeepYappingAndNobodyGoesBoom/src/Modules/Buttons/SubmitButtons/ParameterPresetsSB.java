package Modules.Buttons.SubmitButtons;

import Frames.Bomb;
import Modules.Panels.PPContainer;
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
        int counter = 0;
        for(Component tile : presets.getComponents()){
            if (tile instanceof PPContainer){
                if (((PPContainer) tile).getPic().getFileName().equals(presets.getCombinations().get(Integer.parseInt(presets.getCombination().getText()))[counter])){
                    counter++;
                } else{
                    correct = false;
                    Bomb.strikePlus();
                    break;
                }
            }
        }
        if (correct){
            for (Component label : presets.getComponents()){
                if (label instanceof PPContainer){
                    for (Component component : ((PPContainer) label).getComponents()){
                        component.setEnabled(false);
                    }
                }
            }
            //presets;
        }
    }


}
