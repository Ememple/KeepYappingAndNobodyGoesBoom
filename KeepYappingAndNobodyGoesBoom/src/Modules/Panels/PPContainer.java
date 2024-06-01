package Modules.Panels;

import Modules.Buttons.ParameterPresetsButtons.*;
import HelpClasses.*;
import Modules.Labels.ParameterPresetsLabels.PPPic;
import Modules.ParameterPresets;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Holds two buttons and a image.
 */
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

    /**
     * Adds a button for selecting another image.
     */
    public void addUpButton(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(upButton, constraints);
    }

    /**
     * Adds and image.
     */
    public void addPic() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(pic, constraints);
    }

    /**
     * Same as addUpButton.
     */
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

    /**
     * Selects previous picture.
     * @throws IOException
     */
    public void setPreviousPic() throws IOException {
        try{
            String filename = getPresets().getFileNames().get(getPresets().getFileNames().indexOf(getPic().getFileName()) - 1);
            getPic().setIcon(FilePath.imageIcon(filename));
            getPic().setFileName(filename);

        }catch (IndexOutOfBoundsException indexException) {
            String filename = getPresets().getFileNames().getLast();
            getPic().setIcon(FilePath.imageIcon(filename));
            getPic().setFileName(filename);
        }
    }

    /**
     * Selects next picture.
     * @throws IOException
     */
    public void setNextPic() throws IOException {
        try{
            String filename = getPresets().getFileNames().get(getPresets().getFileNames().indexOf(getPic().getFileName()) + 1);
            getPic().setIcon(FilePath.imageIcon(filename));
            getPic().setFileName(filename);
        }catch (IndexOutOfBoundsException indexException) {
            String filename = getPresets().getFileNames().getFirst();
            getPic().setIcon(FilePath.imageIcon(filename));
            getPic().setFileName(filename);
        }
    }
}
