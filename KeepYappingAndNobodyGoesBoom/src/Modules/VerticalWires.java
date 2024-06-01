package Modules;

import Frames.Bomb;
import HelpClasses.FilePath;
import Modules.Buttons.VerticalWiresButton.VerticalWireButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Vertical wires.
 */
public class VerticalWires extends JPanel {
    private final ArrayList<VerticalWireButton> verticalWireButtons = new ArrayList<>();
    private final ArrayList<Integer> correctOrder = new ArrayList<>();
    private int onWire=0;
    private int neededCutWires =0;

    /**
     * Instantiates a new Vertical wires.
     *
     * @throws IOException the io exception
     */
    public VerticalWires() throws IOException {
        this.setLayout(new GridBagLayout());
        Random random = new Random();
        int numberOfWires =random.nextInt(3,6);
        createLED(random,numberOfWires);
        createWires(random,numberOfWires);
        createStar(random,numberOfWires);
        createCorrectOrder();
        checkIfCleared();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }

    /**
     * Create led.
     *
     * @param random        the random
     * @param numberOfWires the number of wires
     * @throws IOException the io exception
     */
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
                    image = new JLabel(FilePath.imageIcon("/LEDoff.png"));
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

    /**
     * Create wires.
     *
     * @param random        the random
     * @param numberOfWires the number of wires
     */
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
            verticalWireButtons.get(i).setPosition(onWire);
            addAction(onWire, i);
            onWire++;

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

    /**
     * Create star.
     *
     * @param random        the random
     * @param numberOfWires the number of wires
     * @throws IOException the io exception
     */
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

    /**
     * Create correct order.
     */
    public void createCorrectOrder(){
        for (int i =0; i<verticalWireButtons.size();i++ ){
            switch (verticalWireButtons.get(i).getValue()) {
                case 0:
                    if (verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        correctOrder.add(0);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()) {
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    else if (verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()){
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    break;
                case 1:
                    if (verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()) {
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    else if (verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()){
                        correctOrder.add(0);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    break;
                case 2:
                    if (verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        correctOrder.add(0);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()) {
                        correctOrder.add(0);
                    }
                    else if (verticalWireButtons.get(i).isLed() && verticalWireButtons.get(i).isStar()){
                        neededCutWires++;
                        correctOrder.add(5);
                    }
                    else if (!verticalWireButtons.get(i).isLed() && !verticalWireButtons.get(i).isStar()){
                        correctOrder.add(0);
                    }
                    break;
            }
        }
    }

    /**
     * Check correct order.
     *
     * @param position the position
     */
    public void checkCorrectOrder(int position){
        if (correctOrder.get(position)==5){

        }else {
            Bomb.strikePlus();
        }
        verticalWireButtons.get(position).setBackground(Color.GRAY);
        verticalWireButtons.get(position).setEnabled(false);
    }

    /**
     * Add action to wire button.
     *
     * @param position the position
     * @param i        the
     */
    public void addAction(int position, int i){
        verticalWireButtons.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCorrectOrder(position);
                checkIfCleared();
            }
        });
    }

    /**
     * Gets vertical wire buttons.
     *
     * @return the vertical wire buttons
     */
    public ArrayList<VerticalWireButton> getVerticalWireButtons() {
        return verticalWireButtons;
    }

    /**
     * Check if cleared.
     */
    public void checkIfCleared(){
        int cutWires=0;
        for (int i=0; i<verticalWireButtons.size(); i++){
            if (!verticalWireButtons.get(i).isEnabled()){
                cutWires++;
            }
        }
        if (cutWires== neededCutWires){
            Bomb.cleared.add(true);
            for (int i=0; i<verticalWireButtons.size(); i++){
                verticalWireButtons.get(i).setEnabled(false);
            }
        }
    }
}
