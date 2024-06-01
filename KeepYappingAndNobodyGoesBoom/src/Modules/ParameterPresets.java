package Modules;

import Frames.Bomb;
import Modules.Buttons.SubmitButtons.ParameterPresetsSB;
import Modules.Panels.PPContainer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ParameterPresets extends Module{
    private ArrayList<String> fileNames;
    private HashMap<Integer, String[]> combinations;
    private JLabel combination;
    //private ParameterPresetsSB submitButton;
    
    public ParameterPresets(Bomb bomb) throws IOException {
        super(bomb);
        fileNames = new ArrayList<>();
        combinations = new HashMap<>();
        combination = new JLabel();
        //submitButton = new ParameterPresetsSB(this);

        createFileNames();
        setLayout(new GridBagLayout());
        addContainers();
        addCombination();
        addSubmitButton();
        createCombinations();
        setBackground(Color.ORANGE);
        setVisible(true);
        System.out.println(fileNames);
    }

    /**
     * Adds a Container which includes buttons and a image.
     * @throws IOException
     */
    public void addContainers() throws IOException {
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i;
            constraints.gridy = 1;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;

            constraints.weightx = 1;
            constraints.weighty = 1;

            add(new PPContainer(this), constraints);
        }
    }

    /**
     * Reads and saves file names from external file.
     */
    public void createFileNames(){
        String path = "/PPPics";
        URL url = getClass().getResource(path);

        if (url != null) {
            File directory = new File(url.getPath());
            if (directory.isDirectory()) {
                for (File file : directory.listFiles()) {
                    fileNames.add("" + file.getName());
                }
            }
        }
    }

    /**
     * Adds number indicating the right combination.
     */
    public void addCombination(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.VERTICAL;

        constraints.weightx = 3;
        constraints.weighty = 1;

        combination.setText("" + getRandom().nextInt(0, 10));
        combination.setFont(new Font("monospaced", Font.PLAIN, 100));
        combination.setForeground(Color.BLACK);

        add(combination, constraints);
    }

    /**
     * Saves valid combination into a collection.
     */
    public void createCombinations(){
        combinations.put(0, new String[]{"/PPPics/tile006.png", "/PPPics/tile003.png", "/PPPics/tile005.png"});
        combinations.put(1, new String[]{"/PPPics/tile000.png", "/PPPics/tile006.png", "/PPPics/tile007.png"});
        combinations.put(2, new String[]{"/PPPics/tile001.png", "/PPPics/tile006.png", "/PPPics/tile007.png"});
        combinations.put(3, new String[]{"/PPPics/tile007.png", "/PPPics/tile008.png", "/PPPics/tile001.png"});
        combinations.put(4, new String[]{"/PPPics/tile004.png", "/PPPics/tile000.png", "/PPPics/tile002.png"});
        combinations.put(5, new String[]{"/PPPics/tile002.png", "/PPPics/tile005.png", "/PPPics/tile001.png"});
        combinations.put(6, new String[]{"/PPPics/tile004.png", "/PPPics/tile005.png", "/PPPics/tile001.png"});
        combinations.put(7, new String[]{"/PPPics/tile007.png", "/PPPics/tile003.png", "/PPPics/tile004.png"});
        combinations.put(8, new String[]{"/PPPics/tile001.png", "/PPPics/tile006.png", "/PPPics/tile003.png"});
        combinations.put(9, new String[]{"/PPPics/tile001.png", "/PPPics/tile008.png", "/PPPics/tile002.png"});
    }

    /**
     * Adds a submit button.
     */
    public void addSubmitButton(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;

        constraints.gridwidth = 3;
        constraints.gridheight = 1;

        constraints.fill = GridBagConstraints.BOTH;

        constraints.weighty = 20;

        add(new ParameterPresetsSB(this), constraints);
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }

    public HashMap<Integer, String[]> getCombinations() {
        return combinations;
    }

    public JLabel getCombination(){
        return combination;
    }


}
