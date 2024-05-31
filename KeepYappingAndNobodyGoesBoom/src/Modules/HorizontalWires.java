package Modules;

import Frames.Bomb;
import Modules.Buttons.HorizontalWiresButtons.HorizontalWireButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * The type Horizontal wires.
 */
public class HorizontalWires extends JPanel implements Runnable{
    private final ArrayList<HorizontalWireButton> wires = new ArrayList<>();
    private int[] correctOrder;

    /**
     * creates Horizontal wires.
     */
    public HorizontalWires() {
        this.setLayout(new GridLayout(6,1));
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }

    /**
     * Create wires buttons.
     *
     * @param wires the wires
     */
    public void createWires(ArrayList<HorizontalWireButton> wires){
        Random random = new Random();
        int numberOfWires=random.nextInt(3,7);

        for (int i = 0; i<numberOfWires; i++){
            HorizontalWireButton button = new HorizontalWireButton();
            button.setBorder(BorderFactory.createLineBorder(new Color(0x262626),5,false));

            int colour= random.nextInt(5);
            switch (colour){
                case 0:
                    button.setBackground(Color.RED);
                    button.setValue(0);
                    break;
                case 1:
                    button.setBackground(Color.BLUE);
                    button.setValue(1);
                    break;
                case 2:
                    button.setBackground(Color.YELLOW);
                    button.setValue(2);
                    break;
                case 3:
                    button.setBackground(Color.BLACK);
                    button.setValue(3);
                    break;
                case 4:
                    button.setBackground(Color.WHITE);
                    button.setValue(4);
                    break;
            }
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setValue(5);
                    int[]constant =check(wires);
                    button.setEnabled(false);
                    control(wires,constant);
                }
            });
            wires.add(button);
        }
    }

    /**
     * Count colors array list.
     *
     * @param wires the wires
     * @return the array list
     */
    public ArrayList<Integer> countColors(ArrayList<HorizontalWireButton> wires){
        ArrayList<Integer> numberOfColors = new ArrayList<>();
        correctOrder=new int[wires.size()];
        for (int i =0; i<correctOrder.length; i++){
            correctOrder[i]=wires.get(i).getValue();
        }
        int count=0;
        for(int i =0; i<wires.size();i++){
            for(int j =0; j<wires.size();j++){
                if (wires.get(i).getValue()==j){
                    count++;
                }
                numberOfColors.add(count);
            }
        }
        return numberOfColors;
    }

    /**
     * Checks the correct order.
     *
     * @param wires the wires
     * @return the int [ ]
     */
    public int[] check(ArrayList<HorizontalWireButton> wires){
        ArrayList<Integer> countOfColors = countColors(wires);
        switch (wires.size()){
            case 3:
                if (countOfColors.get(0)==0){
                    correctOrder[1]=5;
                } 
                else if (wires.get(2).getValue()==4) {
                    correctOrder[2]=5;
                }
                else if (countOfColors.get(1)>1) {
                    correctOrder[0]=5;
                }
                else {
                    correctOrder[2]=5;
                }
                break;

            case 4:
                if (countOfColors.get(0)>1){
                    correctOrder[3]=5;
                }
                else if (wires.get(3).getValue()==2 && countOfColors.get(0)==0) {
                    correctOrder[0]=5;
                }
                else if (countOfColors.get(1)==1) {
                    correctOrder[0]=5;
                }
                else if (countOfColors.get(2)>1) {
                    correctOrder[3]=5;
                }
                else {
                    correctOrder[1]=5;
                }
                break;

            case 5:
                if (wires.get(4).getValue()==3){
                    correctOrder[3]=5;
                }
                else if (countOfColors.get(0)==1 && countOfColors.get(2)>2) {
                    correctOrder[0]=5;
                }
                else if (countOfColors.get(3)==0) {
                    correctOrder[1]=5;
                }
                else {
                    correctOrder[0]=5;
                }
                break;

            case 6:
                if (countOfColors.get(2)==0){
                    correctOrder[2]=5;
                }
                else if (countOfColors.get(2)==1 && countOfColors.get(4)>1) {
                    correctOrder[3]=5;
                }
                else if (countOfColors.get(0)==0) {
                    correctOrder[5]=5;
                }
                else {
                    correctOrder[3]=5;
                }
                break;
        }
        return correctOrder;
    }

    /**
     * controls the order.
     *
     * @param wires        the wires
     * @param correctOrder the correct order
     */
    public void control(ArrayList<HorizontalWireButton> wires, int[] correctOrder){
        int helpInt=0;
        for (int i =0; i<wires.size();i++){
            if (wires.get(i).getValue()==correctOrder[i]){
                helpInt++;
            }
        }
        if (helpInt==wires.size()){
            for (int j=0; j<this.getComponents().length; j++){
                this.getComponent(j).setBackground(Color.GRAY);
                this.getComponent(j).setEnabled(false);
            }
        }
        else {
            Bomb.strikePlus();
            for (int j=0; j<this.getComponents().length; j++){
                this.getComponent(j).setBackground(Color.GRAY);
                this.getComponent(j).setEnabled(false);
            }
        }
        Bomb.cleared.add(true);
        System.out.println("Cleared Horizontal wires");
    }
    @Override
    public void run() {
        createWires(wires);
        check(wires);
        while (true){
            int helpNumber=0;
            if (correctOrder!=null){
                for (int i=0; i<correctOrder.length;i++){
                    if (correctOrder[i]==5) {
                        helpNumber++;
                    }
                }
                if (helpNumber>1){
                    check(wires);
                }
                else {
                    break;
                }
            }
        }
        for (int i =0; i<wires.size(); i++){
            this.add(wires.get(i));
        }

    }
}
