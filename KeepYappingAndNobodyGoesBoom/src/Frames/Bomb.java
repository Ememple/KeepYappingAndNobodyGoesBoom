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
        HorizontalWires horizontalWires= new HorizontalWires();
        Thread horizontalWiresThread = new Thread(horizontalWires);
        horizontalWiresThread.start();
        Symbols symbols = new Symbols();
        VerticalWires verticalWires = new VerticalWires();
        bomb.add(bombTimer);
        bomb.add(horizontalWires);
        bomb.add(new Password());
        bomb.add(new Memory());
        bomb.add(symbols);
        bomb.add(verticalWires);
        bomb.add(new ParameterPresets());
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
        switch (random.nextInt(0,5)+1){
            case 1 -> {
                //dráty

            }
            case 2 -> {
                //heslo
                return new Password();
            }
            case 3 -> {
                //paměť
                return new Memory();
            }
            case 4 -> {
                //předvolby parametrů
                return new ParameterPresets();
            }
            case 5 -> {
                //modul 5
            }
        }
        return null;
    }
}
