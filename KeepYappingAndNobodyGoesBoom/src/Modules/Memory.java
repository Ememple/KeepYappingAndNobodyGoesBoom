package Modules;

import Frames.Bomb;
import Modules.Buttons.MemoryButtons.ChangeNumberButton;
import Modules.StageBars.MemoryStageBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Memory extends Module{
    private ArrayList<Integer> numbers;
    private JLabel numberDisplay;
    private int stage;
    private HashMap<Integer, ChangeNumberButton> buttons;
    private MemoryStageBar mSB;

    public Memory(Bomb bomb){
        super(bomb);
        stage = 1;
        numbers = new ArrayList<>();
        setLayout(new GridBagLayout());
        buttons = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            numbers.add(i);
        }
        addNumberDisplay();
        addChangeNumberButtons();
        mSB = new MemoryStageBar();
        addProgressBar();
        setVisible(true);
    }

    /**
     * Adds a Progress bar into Memory module.
     */
    public void addProgressBar(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 5;
        constraints.gridy = 1;

        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.weightx = 0.75;
        constraints.weighty = 1;

        add(mSB, constraints);
    }

    /**
     * Adds Buttons for changing numbers into the Module
     */
    public void addChangeNumberButtons(){
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 4; i++) {
            constraints.gridx = i;
            constraints.gridy = 2;

            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;

            constraints.weightx = 1;
            constraints.weighty = 1;
            int index;
            try{
                index = getRandom().nextInt(0, numbers.size());
                int labelText = numbers.get(index);
                numbers.remove((Object) labelText);
                add(new ChangeNumberButton(this, labelText, i), constraints);
            }catch (IllegalArgumentException iAE){
                iAE.printStackTrace();
            }
        }
        for (int i = 1; i < 5; i++) {
            numbers.add(i);
        }
    }

    /**
     * Creates a number display.
     */
    public void addNumberDisplay(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.gridwidth = 4;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.VERTICAL;

        constraints.weightx = 1;
        constraints.weighty = 1;

        initialize_displayed_number();
        numberDisplay.setFont(new Font("monospaced", Font.PLAIN, 120));
        add(numberDisplay, constraints);
    }

    /**
     * Removes all Buttons from collection when stage is failed.
     */
    public void removeChangeNumberButtons(){
        for (Component chNB : this.getComponents()) {
            if (chNB instanceof ChangeNumberButton){
                remove(chNB);
            }
        }
    }

    /**
     * Creates number for display.
     */
    public void initialize_displayed_number() {
        numberDisplay = new JLabel(STR."\{numbers.get(getRandom().nextInt(0, 4))}");
    }

    /**
     * Creates new number for display.
     */
    public void newDisplay(){
        numberDisplay.setText(STR."\{numbers.get(getRandom().nextInt(0, 4))}");
    }

    public JLabel getNumberDisplay(){
        return this.numberDisplay;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public HashMap<Integer, ChangeNumberButton> getButtons() {
        return buttons;
    }

    public MemoryStageBar getMSB() {
        return mSB;
    }
}
