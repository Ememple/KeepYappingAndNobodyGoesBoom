package Modules.Buttons.SimonSaysButtons;

import Frames.Bomb;
import Modules.Buttons.ModuleButton;
import Modules.SimonSays;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ColoredButton extends ModuleButton {
    private SimonSays simon;
    private String color;
    public ColoredButton(SimonSays simon, Color background, String color){
        super();
        this.simon = simon;
        this.color = color;
        setBackground(background);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        try {
            System.out.println(STR."Simon stage = \{simon.getStage()}");
            String matchColor;
            if (simon.getStage() == 0){
                matchColor = simon.getLed().getColor();
            } else{
                matchColor = simon.getTemporary().getColor();
            }

            switch(Bomb.strikes){
                case 0 -> {
                    switch (matchColor){ //simon.getLed().getColor().equals(color)
                        case "red" -> {
                            if (color.equals("blue")){
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
                    switch (simon.getLed().getColor()){ //simon.getLed().getColor().equals(color)
                        case "red" -> {
                            if (color.equals("yellow")){
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
                    switch (simon.getLed().getColor()){ //simon.getLed().getColor().equals(color)
                        case "red" -> {
                            if (color.equals("green")){
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
                    switch (simon.getLed().getColor()){ //simon.getLed().getColor().equals(color)
                        case "red" -> {
                            if (color.equals("red")){
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

    public void flash() throws InterruptedException {
        Color background;
        switch(color){
            case "blue" -> {
                background = Color.BLUE;
            }
            case "red" -> {
                background = Color.RED;
            }
            case "green" -> {
                background = Color.GREEN;
            }
            case "yellow" -> {
                background = Color.YELLOW;
            }
            default -> {
                background = null;
            }
        }
        System.out.println("Flash color " + color);
        setBackground(background);
        repaint();
        setVisible(true);
        Thread.sleep(1000);
        setBackground(Color.LIGHT_GRAY);
        repaint();
        setVisible(true);
    }

    public void nextStage(){
        simon.setStage(simon.getStage()+1);
        winCondition();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void winCondition(){
        if (simon.getStage() > 4){
            simon.disable();
        }
    }
}
