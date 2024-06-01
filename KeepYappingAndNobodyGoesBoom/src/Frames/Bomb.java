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
public class Bomb implements Runnable{
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
        }
    }

    /**
     * Check if all modules are cleared.
     */
    public static void checkAllCleared(Timer timer){
        int winCondition=0;
        for (int i=0; i<5; i++){
            if (cleared.get(i)==true){
                winCondition++;
            }
        }
        if (winCondition==5){
            WinScreen winScreen = new WinScreen();
            timer.stop();
        }
    }

    /**
     * Starts bomb.
     *
     * @throws IOException the io exception
     */
    public void bombStart() throws IOException {
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

        bomb.add(bombTimer);
        for (int i = 0; i < 5; i++) {
            bomb.add(randomModule());
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
                return new VerticalWires();
            }
            case 1 -> {
                return new Password(this);
            }
            case 2 -> {
                return new Memory(this);
            }
            case 3 -> {
                return new ParameterPresets(this);
            }
            case 4 -> {
                return new HorizontalWires();
            }
            case 5 -> {
                return new SimonSays(this);
            }
            case 6 -> {
                return new Symbols();
            }
        }
        return null;
    }

    @Override
    public void run() {
        try {
            bombStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
