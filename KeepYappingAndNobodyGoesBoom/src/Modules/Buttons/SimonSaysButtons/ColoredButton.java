package Modules.Buttons.SimonSaysButtons;

import Frames.Bomb;
import Modules.Buttons.ModuleButton;
import Modules.SimonSays;

import java.awt.*;
import java.awt.event.ActionEvent;

import static java.lang.Thread.sleep;

/**
 * Lights up when clicked.
 */
public class ColoredButton extends ModuleButton {
    private SimonSays simon;
    private String color;
    private Color original_background;
    public ColoredButton(SimonSays simon, Color background, String color){
        super();
        this.simon = simon;
        this.color = color;
        this.original_background = background;
        setText(" ");

        setFont(new Font("monospaced", Font.PLAIN, 80));
        setBackground(original_background);
        setSize(250, 250);
        setVisible(true);
    }

    /**
     * Checks if pressed button was the correct one.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            //System.out.println(STR."Simon stage = \{simon.getStage()}");
            String matchColor;
            if (simon.getStage() == 0){
                matchColor = simon.getLed().getColor();
            } else{
                matchColor = simon.getTemporary().getColor();
            }

            switch(Bomb.strikes){
                case 0 -> {
                    switch (matchColor){
                        case "red" -> {
                            if (color.equals("blue")){
                                winCondition();
                                nextStage();
                                simon.getBlue().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "blue" -> {
                            if (color.equals("red")){
                                winCondition();
                                nextStage();
                                simon.getRed().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "green" -> {
                            if (color.equals("yellow")){
                                winCondition();
                                nextStage();
                                simon.getYellow().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "yellow" -> {
                            if (color.equals("green")){
                                winCondition();
                                nextStage();
                                simon.getGreen().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                    }
                }



                case 1 -> {
                    switch (matchColor){
                        case "red" -> {
                            if (color.equals("yellow")){
                                winCondition();
                                nextStage();
                                simon.getYellow().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "blue" -> {
                            if (color.equals("green")){
                                winCondition();
                                nextStage();
                                simon.getGreen().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "green" -> {
                            if (color.equals("blue")){
                                winCondition();
                                nextStage();
                                simon.getBlue().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "yellow" -> {
                            if (color.equals("red")){
                                winCondition();
                                nextStage();
                                simon.getRed().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                    }
                }


                case 2 -> {
                    switch (matchColor){
                        case "red" -> {
                            if (color.equals("green")){
                                winCondition();
                                nextStage();
                                simon.getGreen().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "blue" -> {
                            if (color.equals("red")){
                                winCondition();
                                nextStage();
                                simon.getRed().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "green" -> {
                            if (color.equals("yellow")){
                                winCondition();
                                nextStage();
                                simon.getYellow().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "yellow" -> {
                            if (color.equals("blue")){
                                winCondition();
                                nextStage();
                                simon.getBlue().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                    }
                }



                case 3 -> {
                    switch (matchColor){
                        case "red" -> {
                            if (color.equals("red")){
                                winCondition();
                                nextStage();
                                simon.getRed().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "blue" -> {
                            if (color.equals("blue")){
                                winCondition();
                                nextStage();
                                simon.getBlue().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "green" -> {
                            if (color.equals("green")){
                                winCondition();
                                nextStage();
                                simon.getGreen().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                        case "yellow" -> {
                            if (color.equals("yellow")){
                                winCondition();
                                nextStage();
                                simon.getYellow().flash();
                                simon.setTemporary(simon.randomButton());
                                simon.getTemporary().flash();
                            } else {
                                Bomb.strikePlus();
                            }
                        }
                    }
                }
            }

        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Lights up the button briefly.
     * @throws InterruptedException
     */
    public void flash() throws InterruptedException {
        Color background;
        switch(color){
            case "blue" -> background = Color.BLUE;

            case "red" -> background = Color.RED;

            case "green" -> background = Color.GREEN;

            case "yellow" -> background = Color.YELLOW;

            default -> background = null;
        }
        setBackground(background);
        repaint();
        setVisible(true);
        new Thread(()->{
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ColoredButton.this.setBackground(this.original_background);
        }).start();
        setVisible(true);
    }

    public void nextStage(){
        simon.setStage(simon.getStage()+1);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Checks if winning conditions were met.
     */
    public void winCondition(){
        if (simon.getStage() > 4){
            simon.disableModule();
            Bomb.cleared.add(true);
        }
    }
}
