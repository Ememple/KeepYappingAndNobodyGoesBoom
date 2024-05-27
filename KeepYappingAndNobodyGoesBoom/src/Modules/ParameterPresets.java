package Modules;

import Modules.Buttons.ParameterPresets.*;
import Modules.PPPic.PPPic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.text.StyleConstants.setIcon;

public class ParameterPresets extends Module{
    private UpButton up;
    private DownButton down;
    //private PPPic pic;
    private ArrayList<String> fileNames = new ArrayList<>();
    
    public ParameterPresets(){
        super();
        up = new UpButton(this);
        down = new DownButton(this);
        createFileNames();
        setLayout(new GridBagLayout());
        addLabels();
        setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void addLabels(){
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i+1;
            constraints.gridy = 1;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;

            constraints.weightx = 1;
            constraints.weighty = 1;

            add(new PPPic(STR."PPPics/\{fileNames.get(getRandom().nextInt(0, fileNames.size()))}"), constraints);
        }
    }

    public void createFileNames(){
        String fileName = "PPPics";
        for (final File fileEntry : Objects.requireNonNull(new File(fileName).listFiles())) {
            if (!fileEntry.isDirectory()) {
                fileNames.add(fileEntry.getName());
            }
        }
    }
}
