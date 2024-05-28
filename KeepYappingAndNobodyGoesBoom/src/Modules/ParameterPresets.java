package Modules;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class ParameterPresets extends Module{
    //private PPPic pic;
    private ArrayList<String> fileNames;
    
    public ParameterPresets(){
        super();
        fileNames = new ArrayList<>();
        createFileNames();
        setLayout(new GridBagLayout());
        addContainers();
        setBackground(Color.WHITE);
        setVisible(true);
        System.out.println(fileNames);
    }
    
    public void addContainers(){
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            constraints.gridx = i+1;
            constraints.gridy = 1;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;

            constraints.weightx = 1;
            constraints.weighty = 1;

            add(new PPContainer(this), constraints);
        }
    }

    public void createFileNames(){
        String fileName = "PPPics";
        for (final File fileEntry : Objects.requireNonNull(new File(fileName).listFiles())) {
            if (!fileEntry.isDirectory()) {
                fileNames.add(fileName + "/" + fileEntry.getName());
            }
        }
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }
}
