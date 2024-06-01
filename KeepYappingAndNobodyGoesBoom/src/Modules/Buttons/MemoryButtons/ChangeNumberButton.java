package Modules.Buttons.MemoryButtons;

import Frames.Bomb;
import Modules.Buttons.ModuleButton;
import Modules.Memory;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Changes the displayed number.
 */
public class ChangeNumberButton extends ModuleButton {
    Memory memory;
    int position;
    int number;

    public ChangeNumberButton(Memory memory, int number, int position) {
        super();
        this.memory = memory;
        this.number = number;
        setText("" + this.number);
        setFont(new Font("monospaced", Font.PLAIN, 30));
        setBackground(Color.WHITE);
        //this.buttons = new ChangeNumberButton[5];
        this.position = position;
    }

    /**
     * Checks if the pressed button was the correct one.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(memory.getButtons());
        switch (memory.getStage()) {
            case 1 -> {
                switch (memory.getNumberDisplay().getText()) {
                    case "1" -> {
                        if (number == 2) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (position == 1) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (position == 0) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (number == 4) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                }
            }
            case 2 -> {
                switch (memory.getNumberDisplay().getText()) {
                    case "1" -> {
                        if (this.number == memory.getButtons().get(1).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (number == 3) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (position == 0) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.position == memory.getButtons().get(1).position) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                }
            }
            case 3 -> {
                switch (memory.getNumberDisplay().getText()) {
                    case "1" -> {
                        if (this.position == memory.getButtons().get(2).position) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.position == memory.getButtons().get(1).position) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (this.number == memory.getButtons().get(1).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.number == 1) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                }
            }
            case 4 -> {
                switch (memory.getNumberDisplay().getText()) {
                    case "1" -> {
                        if (this.number == memory.getButtons().get(1).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.number == memory.getButtons().get(2).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (this.position == 1) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.position == memory.getButtons().get(1).position) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                }
            }
            case 5 -> {
                switch (memory.getNumberDisplay().getText()) {
                    case "1" -> {
                        if (this.number == memory.getButtons().get(1).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.number == memory.getButtons().get(3).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (this.position == memory.getButtons().get(1).position) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.number == memory.getButtons().get(2).number) {
                            nextStage();
                        } else {
                            resetStage();
                        }
                    }
                }
            }
        }
    }

    public void nextStage() {
        memory.getButtons().put(memory.getStage(), this);
        memory.removeChangeNumberButtons();
        memory.addChangeNumberButtons();
        memory.setStage(memory.getStage() + 1);
        memory.newDisplay();
        memory.getMSB().setValue(memory.getStage() - 1);
        if (memory.getMSB().getValue() == 5) {
            memory.disableModule();
            Bomb.cleared.add(true);
        }
    }

    public void resetStage() {
        memory.removeChangeNumberButtons();
        memory.addChangeNumberButtons();
        Bomb.strikePlus();
        memory.setStage(1);
        memory.newDisplay();
        memory.getMSB().setValue(0);
        //clearNumbers();
    }
}
