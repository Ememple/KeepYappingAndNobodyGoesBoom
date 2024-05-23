package Modules.Buttons.MemoryButtons;

import Frames.Bomb;
import Modules.Buttons.ModuleButton;
import Modules.Memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ChangeNumberButton extends ModuleButton {
    Memory memory;
    int position;
    int number;
    ChangeNumberButton[] buttons;

    public ChangeNumberButton(Memory memory, int number, int position){
        super();
        setText("" + number);
        setFont(new Font("monospaced", Font.PLAIN, 30));
        this.memory = memory;
        this.number = number;
        this.buttons = new ChangeNumberButton[5];
        this.position = position;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch(memory.getStage()){
            /*case 6 -> {
                memory.disable();
            }*/
            case 1 -> {
                switch(memory.getNumberDisplay().getText()){
                    case "1" -> {
                        if (number == 2){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (position == 1){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (position == 0){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (position == 3){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                }
            }
            case 2 ->{
                switch(memory.getNumberDisplay().getText()){
                    case "1" -> {
                        if (this.toString().equals(buttons[0].toString())){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (number == 3){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (position == 0){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.position == buttons[0].position){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                }
            }
            case 3 ->{
                switch(memory.getNumberDisplay().getText()){
                    case "1" -> {
                        if (this.position == buttons[1].position){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.position == buttons[0].position){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (position == 0){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.number == 1){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                }
            }
            case 4 ->{
                switch(memory.getNumberDisplay().getText()){
                    case "1" -> {
                        if (this.toString().equals(buttons[2].toString())){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.number == buttons[1].number){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "3" -> {
                        if (this.position == 1){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.position == buttons[0].position){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                }
            }
            case 5 ->{
                switch(memory.getNumberDisplay().getText()){
                    case "1", "3" -> {
                        if (this.number == buttons[0].number){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "2" -> {
                        if (this.number == buttons[2].number){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                    case "4" -> {
                        if (this.number == buttons[1].number){
                            nextStage();
                        }else {
                            resetStage();
                        }
                    }
                }
                memory.disable();
            }
        }
    }

    public void nextStage(){
        memory.setStage(memory.getStage()+1);
        memory.initialize_displayed_number();
        buttons[memory.getStage()-2] = this;
    }

    public void resetStage(){
        Bomb.strikePlus();
        memory.setStage(1);
        clearNumbers();
    }

    public void clearNumbers(){
        buttons = new ChangeNumberButton[6];
    }

    @Override
    public String toString() {
        return "ChangeNumberButton{" +
                "number=" + number + '}';
    }
}
