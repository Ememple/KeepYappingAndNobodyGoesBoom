package Modules;

import Frames.Bomb;
import Modules.HorizontalWiresButtons.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class HorizontalWires extends JPanel implements Runnable{
    ArrayList<MyButton> wires = new ArrayList<>();
    int[] correctOrder;
    public HorizontalWires() {
        this.setLayout(new GridLayout(5,1));
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }
    public void createWires(ArrayList<MyButton> wires,int[] correctOrder){
        Random random = new Random();
        int numberOfWires= 3;//random.nextInt(3,6);

        for (int i = 0; i<numberOfWires; i++){
            MyButton button = new MyButton();

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
    public ArrayList<Integer> countColors(ArrayList<MyButton> wires){
        ArrayList<Integer> numberOfColors = new ArrayList<>();
        correctOrder=new int[wires.size()];
        for (int i =0; i<correctOrder.length; i++){
            correctOrder[i]=wires.get(i).getValue();
        }
        int count=0;
        for(int i =0; i<wires.size();i++){
            for(int j =0; j<wires.size();j++){
                if (wires.get(i).getValue()==i){
                    count++;
                }
                numberOfColors.add(count);
            }
        }
        return numberOfColors;
    }
    public int[] check(ArrayList<MyButton> wires){
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
                break;
        }
        return correctOrder;
    }
    public void control(ArrayList<MyButton> wires, int[] correctOrder){
        for (int j =0; j<correctOrder.length;j++){
            System.out.println(correctOrder[j]);
        }
        boolean chill= true;
        for (int i =0; i<wires.size();i++){
            if (wires.get(i).getValue()==correctOrder[i]){
                System.out.println("GG");
                for (int j=0; j<this.getComponents().length; j++){
                    this.getComponent(j).setBackground(Color.GRAY);
                    this.getComponent(j).setEnabled(false);
                }
            }
            else {
                chill=false;
                Bomb.strikePlus();
                System.out.println("Retard");
            }
        }
    }
    @Override
    public void run() {
        createWires(wires,correctOrder);
        System.out.println("Wires: "+wires.size());
        check(wires);
        for (int i =0; i<wires.size(); i++){
            this.add(wires.get(i));
        }

    }
}
