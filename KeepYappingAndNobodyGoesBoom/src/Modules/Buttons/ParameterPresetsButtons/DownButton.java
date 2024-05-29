package Modules.Buttons.ParameterPresetsButtons;

import HelpClasses.FilePath;
import Modules.Buttons.ModuleButton;
import Modules.PPContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DownButton extends ModuleButton {
    //private ParameterPresets presets;
    private PPContainer container;
    private ImageIcon icon;
    public DownButton(PPContainer container) throws IOException {
        super();
        //this.presets = presets;
        this.container = container;
        icon = FilePath.imageIcon("/up and down buttons/downButton.png");
        setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            container.setNextPic();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
