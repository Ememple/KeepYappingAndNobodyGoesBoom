import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Bomb extends JFrame {
    private ArrayList<JPanel> panels;

    public Bomb(){
        panels = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
        setIconImage(new ImageIcon("ImageIcon.jpg").getImage());
        setResizable(true);
        setLayout(new GridLayout(2,3,5,5));
        setVisible(true);
    }

    public void start(){
        for (int i = 0; i < 6; i++) {
            panels.add(new JPanel());
            panels.get(i).setLayout(new BorderLayout());
            randomModule(panels.get(i));
            panels.get(i).setVisible(true);
        }
        //panels.getLast().add(timer());
        for (int i = 0; i < panels.size(); i++) {
            add(panels.get(i));
        }
        setVisible(true);
    }

    public void randomModule(JPanel panel){
        Random random = new Random();
        switch (random.nextInt(0,5)+1){
            case 1 -> {
                //dráty
                JButton yellow = new JButton();
                yellow.setText("cut wire");
                yellow.setBackground(Color.YELLOW);
                yellow.setVisible(true);
                JButton blue = new JButton();
                blue.setText("cut wire");
                blue.setBackground(Color.BLUE);
                blue.setVisible(true);
                JButton red = new JButton();
                red.setText("cut wire");
                red.setBackground(Color.RED);
                red.setVisible(true);
                panel.add(yellow);
                panel.add(blue);
                panel.add(red);
            }
            case 2 -> {
                //tlačítko //jsem cooked, Fíla nepomáhá
                //panel.add();
            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }
    }

    /*public Timer timer(){

    }*/
}
