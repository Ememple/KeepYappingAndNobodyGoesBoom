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
            add(randomModule());
        }
        //panels.getLast().add(timer());
        for (int i = 0; i < panels.size(); i++) {
            add(panels.get(i));
        }
        setVisible(true);
    }

    public Component randomModule(){
        Random random = new Random();
        switch (random.nextInt(0,5)+1){
            case 1 -> {
                //dráty
                return new Wires();
            }
            case 2 -> {
                //tlačítko

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
        }

        return null;
    }
}
