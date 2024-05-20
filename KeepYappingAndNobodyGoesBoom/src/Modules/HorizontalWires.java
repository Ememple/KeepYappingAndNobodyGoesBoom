package Modules;

import Modules.HorizontalWiresButtons.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class HorizontalWires extends JPanel implements Runnable{
    ArrayList<MyButton> wires = new ArrayList<>();
    int[] correctOrder= new int[5];
    public HorizontalWires() {
        createWires(wires,correctOrder);
        for (int i =0; i<wires.size(); i++){
            this.add(wires.get(i));
        }
        this.setLayout(new GridLayout(5,1));
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }
    public void createWires(ArrayList<MyButton> wires,int[] correctOrder){
        Random random = new Random();
        int numberOfWires= random.nextInt(3,6);

        for (int i = 0; i<numberOfWires; i++){
            MyButton button = new MyButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setValue(5);
                    control(wires,correctOrder);
                }
            });

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
            wires.add(button);
        }
    }
    public int[] check(ArrayList<MyButton> wires, int[] correctOrder){

        ArrayList<Integer> countOfColors = new ArrayList<>();
        int count=0;
        for(int i =0; i<wires.size();i++){
            for(int j =0; i<wires.size();j++){
                if (wires.get(i).getValue()==i){
                    count++;
                }
                countOfColors.add(count);
            }

        }
        switch (wires.size()){
            case 3:
                if (countOfColors.get(0)==0){
                    if (countOfColors.get(3)==0){
                        correctOrder[2]=5;
                    }
                    else {
                        correctOrder[1]=5;
                    }
                }
                else if (countOfColors.get(0)==1) {
                    if (countOfColors.get(2)==0){
                        correctOrder[0]=5;
                    }
                    else {
                        correctOrder[1]=5;
                    }
                }
                else {
                    correctOrder[1]=5;
                }
                break;
            }
        return correctOrder;
    }
    public void control(ArrayList<MyButton> wires, int[] correctOrder){
        boolean chill= true;
        for (int i =0; i<wires.size();i++){
            if (wires.get(i).getValue()==correctOrder[i]){
            }
            else {
                chill=false;
                System.exit(0);
            }
        }
    }
    @Override
    public void run() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check(wires,correctOrder);
            }
        });
    }
}
