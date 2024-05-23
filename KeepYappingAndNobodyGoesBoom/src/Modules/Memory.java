package Modules;

import Modules.Buttons.MemoryButtons.ChangeNumberButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Memory extends Module{
    ArrayList<Integer> numbers;
    private JLabel numberDisplay;
    private int stage;
    //ChangeNumberButton chNB;
    public Memory(){
        super();
        stage = 1;
        numbers = new ArrayList<>();
        setLayout(new GridBagLayout());
        for (int i = 1; i < 5; i++) {
            numbers.add(i);
        }
        System.out.println("konstruktor " + numbers);
        addNumberDisplay();
        addChangeNumberButtons();
        //chNB = new ChangeNumberButton(this, Integer.parseInt(numberDisplay.getText()));
        setVisible(true);
    }

    public void addChangeNumberButtons(){
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 5; i++) {
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
            }catch (IllegalArgumentException ignored){}
        }
        for (int i = 1; i < 5; i++) {
            numbers.add(i);
        }
    }

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

    public void initialize_displayed_number() {
        System.out.println("metoda " +  numbers);
        numberDisplay = new JLabel("" + numbers.get(getRandom().nextInt(0, 4)));
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
}
