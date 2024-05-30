package Modules;

import HelpClasses.FilePath;
import Modules.Buttons.VerticalWiresButton.VerticalWireButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class VerticalWires extends JPanel {
    private final ArrayList<VerticalWireButton> verticalWireButtons = new ArrayList<>();
    private final ArrayList<Integer> correctOrder = new ArrayList<>();

    public VerticalWires() throws IOException {
        this.setLayout(new GridBagLayout());
        Random random = new Random();
        int numberOfWires =random.nextInt(3,6);
        createLED(random,numberOfWires);
        createWires(random,numberOfWires);
        createStar(random,numberOfWires);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }
    public void createLED(Random random, int numberOfWires) throws IOException {
        for (int i=0; i<numberOfWires; i++){
            VerticalWireButton verticalWireButton= new VerticalWireButton();
            JLabel image = new JLabel();
            switch (random.nextInt(2)){
                case 0:
                    verticalWireButton.setLed(true);
                    image = new JLabel(FilePath.imageIcon("/LEDon.png"));
                    break;
                case 1:
                    verticalWireButton.setLed(false);
                    image = new JLabel(new ImageIcon("/LEDoff.png"));
                    break;

            }
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx=i;
            gridBagConstraints.gridy=0;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.gridheight=1;
            gridBagConstraints.fill=GridBagConstraints.BOTH;
            gridBagConstraints.weightx=0.5;
            gridBagConstraints.weighty=0.5;
            verticalWireButtons.add(verticalWireButton);
            image.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            this.add(image, gridBagConstraints);
        }
    }
    public void createWires(Random random, int numberOfWires){
        for (int i=0; i<numberOfWires; i++) {
            int color=random.nextInt(3);
            switch (color){
                case 0:
                    verticalWireButtons.get(i).setValue(0);
                    verticalWireButtons.get(i).setBackground(Color.RED);
                    break;
                case 1:
                    verticalWireButtons.get(i).setValue(1);
                    verticalWireButtons.get(i).setBackground(Color.BLUE);

                    break;
                case 2:
                    verticalWireButtons.get(i).setValue(2);
                    verticalWireButtons.get(i).setBackground(Color.WHITE);
                    break;
            }


            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx=i;
            gridBagConstraints.gridy=1;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.gridheight=2;
            gridBagConstraints.fill=GridBagConstraints.VERTICAL;
            gridBagConstraints.weightx=1;
            gridBagConstraints.weighty=2;
            this.add(verticalWireButtons.get(i), gridBagConstraints);
            }
        }
    public void createStar(Random random, int numberOfWires) throws IOException {
        for (int i=0; i<numberOfWires; i++){
            boolean star = true;
            switch (random.nextInt(2)){
                case 0:
                    verticalWireButtons.get(i).setStar(true);
                    star=true;
                    break;
                case 1:
                    verticalWireButtons.get(i).setStar(false);
                    star=false;
                    break;

            }
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx=i;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.gridheight=1;
            gridBagConstraints.fill=GridBagConstraints.BOTH;
            gridBagConstraints.weightx=0.5;
            gridBagConstraints.weighty=0.5;
            JLabel image;
            if (star){
                image = new JLabel(FilePath.imageIcon("/Star.png"));
            }
            else {
                image = new JLabel();
            }
            image.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            this.add(image, gridBagConstraints);
        }
    }
}
