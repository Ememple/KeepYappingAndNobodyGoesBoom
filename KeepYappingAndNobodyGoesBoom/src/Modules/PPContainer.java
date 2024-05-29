package Modules;

import Modules.Buttons.ParameterPresetsButtons.*;
import Modules.PPPic.PPPic;
import HelpClasses.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PPContainer extends JPanel {
    private final UpButton upButton;
    private final DownButton downButton;
    private final PPPic pic;
    private final ParameterPresets presets;

    public PPContainer(ParameterPresets presets) throws IOException {
        super();
        this.presets = presets;
        this.upButton = new UpButton(this);
        this.downButton = new DownButton(this);
        this.pic = new PPPic(presets.getFileNames().get(presets.getRandom().nextInt(0, presets.getFileNames().size())));
        setLayout(new GridBagLayout());
        addUpButton();
        addPic();
        addDownButton();
        setBackground(Color.ORANGE);
        setVisible(true);
    }

    public void addUpButton(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(upButton, constraints);
    }

    public void addPic() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(pic, constraints);
    }

    public void addDownButton(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(downButton, constraints);
    }

    public PPPic getPic() {
        return pic;
    }

    public ParameterPresets getPresets() {
        return presets;
    }

    public void setPreviousPic() throws IOException {
        try{
            String filename = getPresets().getFileNames().get(getPresets().getFileNames().indexOf(getPic().getFileName()) - 1);
            getPic().setIcon(FilePath.imageIconPath(filename));
            getPic().setFileName(filename);

        }catch (IndexOutOfBoundsException indexException) {
            String filename = getPresets().getFileNames().getLast();
            getPic().setIcon(FilePath.imageIconPath(filename));
            getPic().setFileName(filename);
        }
    }

    public void setNextPic() throws IOException {
        try{
            String filename = getPresets().getFileNames().get(getPresets().getFileNames().indexOf(getPic().getFileName()) + 1);
            getPic().setIcon(FilePath.imageIconPath(filename));
            getPic().setFileName(filename);
        }catch (IndexOutOfBoundsException indexException) {
            String filename = getPresets().getFileNames().getFirst();
            getPic().setIcon(FilePath.imageIconPath(filename));
            getPic().setFileName(filename);
        }
    }
}
