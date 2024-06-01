package Frames;

import HelpClasses.FilePath;
import Modules.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * The type Bomb.
 */
public class Bomb {
    public static int strikes=0;
    public static ArrayList<Boolean> cleared = new ArrayList<>();
    JFrame bomb;

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
            System.out.println(STR."Počet chyb \{strikes}");
        }
    }

    /**
     * Check if all modules are cleared.
     */
    public static void checkAllCleared(){
        int winCondition=0;
        for (int i=0; i<5; i++){
            if (cleared.get(i)==true){
                winCondition++;
            }
        }
        if (winCondition==5){
            WinScreen winScreen = new WinScreen();
        }
    }

    /**
     * Starts bomb.
     *
     * @throws IOException the io exception
     */
    public void start() throws IOException {
        bomb = new JFrame();
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
        for (int i = 0; i < 5; i++) {
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
                System.out.println("vertical");
                return new VerticalWires();
            }
            case 1 -> {
                System.out.println("password");
                return new Password(this);
            }
            case 2 -> {
                System.out.println("memory");
                return new Memory(this);
            }
            case 3 -> {
                System.out.println("pp");
                return new ParameterPresets(this);
            }
            case 4 -> {
                System.out.println("horizontal");
                HorizontalWires horizontalWires= new HorizontalWires();
                Thread horizontalWiresThread = new Thread(horizontalWires);
                horizontalWiresThread.start();
                return horizontalWires;
            }
            case 5 -> {
                System.out.println("simon");
                return new SimonSays(this);
            }
            case 6 -> {
                System.out.println("symbols");
                return new Symbols();
            }
        }
        return null;
    }

    /*public void winCondition(){
        boolean win = true;
        for (Component component : bomb.getComponents()){
            if (!(component instanceof BombTimer)){
                if ( component.isEnabled()){
                    win = false;
                    break;
                }
            }
        }
        if (win){
            System.out.println("You disarmed the bomb!");
        }
    }*/
}
