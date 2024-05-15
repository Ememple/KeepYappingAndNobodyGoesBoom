package Modules;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Memory extends Module{
    ArrayList<Integer> numbers;
    public Memory(){
        super();
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        setLayout(new GridLayout(2,1));
        //ukazatel čísla

        //nabídka čísel
        add(new JLabel(String.valueOf(numbers.get(getRandom().nextInt(4)))));
        add(new JLabel("1"));
        setVisible(true);
    }
}
