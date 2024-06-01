package Frames;

import HelpClasses.FilePath;
import Modules.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

/**
 * The type Bomb.
 */
public class Bomb {
    public static int strikes=0;

    /**
     * creates new Bomb.
     */
    public Bomb(){
    }

    /**
     * adds Strike.
     */
    public static void strikePlus(){
        if (strikes>=3){
            System.exit(0);
        }
        else {
            strikes++;
            System.out.println("Počet chyb "+strikes);
        }
    }

    /**
     * Starts bomb.
     *
     * @throws IOException the io exception
     */
    public void start() throws IOException {
        JFrame bomb = new JFrame();
        ImageIcon imageIcon = FilePath.imageIcon("/ImageIcon.jpg");
        bomb.setTitle("Keep Talking And Nobody Explodes");
        bomb.setIconImage(imageIcon.getImage());
        bomb.setBackground(Color.WHITE);
        bomb.setExtendedState(JFrame.MAXIMIZED_BOTH);
        bomb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bomb.setResizable(true);
        bomb.setLayout(new GridLayout(2,3));
        BombTimer bombTimer = new BombTimer();
        /*HorizontalWires horizontalWires= new HorizontalWires();
        Thread horizontalWiresThread = new Thread(horizontalWires);
        horizontalWiresThread.start();*/

        bomb.add(bombTimer);
        for (int i = 0; i < 7; i++) {
            bomb.add(randomModule());
        }
        for (Component component : bomb.getComponents()){
            System.out.println(component.toString());
        }
        bomb.setVisible(true);
    }


    /**
     * Random module component.
     *
     * @return the component
     * @throws IOException the io exception
     */
    public Component randomModule() throws IOException{
        Random random = new Random();
        switch (random.nextInt(0,7)){
            case 0 -> {
                return new HorizontalWires();
            }
            case 1 -> {
                return new Password();
            }
            case 2 -> {
                return new Memory();
            }
            case 3 -> {
                return new ParameterPresets();
            }
            case 4 -> {
                return new VerticalWires();
            }
            case 5 -> {
                return new SimonSays();
            }
            case 6 -> {
                return new Symbols();
            }
        }
        return null;
    }
}
