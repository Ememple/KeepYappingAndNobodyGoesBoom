package Frames;

import Modules.*;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Bomb {
    public void start(){
        JFrame bomb = new JFrame();
        ImageIcon imageIcon = new ImageIcon("imageIcon.jpg");
        bomb.setTitle("Keep Talking And Nobody Explodes");
        bomb.setIconImage(imageIcon.getImage());
        bomb.setBackground(Color.WHITE);
        bomb.setExtendedState(JFrame.MAXIMIZED_BOTH);
        bomb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bomb.setResizable(false);
        bomb.setLayout(new GridLayout(2,3));
        BombTimer bombTimer = new BombTimer(bomb);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.MAGENTA);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.YELLOW);
        bomb.add(bombTimer);
        bomb.add(panel1);
        bomb.add(panel2);
        bomb.add(panel3);
        bomb.add(panel4);
        bomb.setVisible(true);
    }


    public Component randomModule(){
        Random random = new Random();
        switch (random.nextInt(0,5)+1){
            case 1 -> {
                //dráty

            }
            case 2 -> {
                //tlačítko
                return new Button();
            }
            case 3 -> {
                //modul 3
            }
            case 4 -> {
                //modul 4
            }
            case 5 -> {
                //modul 5
            }
        }
        return null;
    }
}
