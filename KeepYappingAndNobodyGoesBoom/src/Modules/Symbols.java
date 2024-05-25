package Modules;

import Frames.Bomb;
import Modules.Buttons.SymbolsButton.SymbolButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Symbols extends JPanel {
    ArrayList<Integer> usedNumbers = new ArrayList<>();
    ArrayList<SymbolButton> symbolButtonArrayList = new ArrayList<>();
    int onButtonNumber =0;
    public Symbols() {
        try {
            createButtons();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setLayout(new GridLayout(2,2));
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
    }
    public void createButtons() throws IOException {
        Random random = new Random();
        int column = random.nextInt(3)+1;
        String columnString ="";
        switch (column){
            case 1:
                columnString="Symbol/Column1";
                break;
            case 2:
                columnString="Symbol/Column2";
                break;
            case 3:
                columnString="Symbol/Column3";
                break;
        }
        for (int i = 0; i<4; i++){
            SymbolButton symbolButton = new SymbolButton();
            symbolButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    correctOrder(symbolButton);
                }
            });
            symbolButton.setFocusable(false);
            int symbolNumber = random.nextInt(7)+1;
            String symbol="";
            switch (checkSymbol(symbolNumber,random)){
                case 1:
                    symbol="/1.png";
                    symbolButton.setValue(1);
                    break;
                case 2:
                    symbol="/2.png";
                    symbolButton.setValue(2);
                    break;
                case 3:
                    symbol="/3.png";
                    symbolButton.setValue(3);
                    break;
                case 4:
                    symbol="/4.png";
                    symbolButton.setValue(4);
                    break;
                case 5:
                    symbol="/5.png";
                    symbolButton.setValue(5);
                    break;
                case 6:
                    symbol="/6.png";
                    symbolButton.setValue(6);
                    break;
                case 7:
                    symbol="/7.png";
                    symbolButton.setValue(7);
                    break;
            }
            String pngPath=columnString+symbol;
            symbolButton.setBackground(Color.WHITE);
            symbolButton.setIcon(new ImageIcon(pngPath));
            symbolButton.setBorder(BorderFactory.createLineBorder(new Color(0xA9A9A9), 2, false));
            symbolButtonArrayList.add(symbolButton);
            this.add(symbolButton);
        }
    }
    public int checkSymbol(int symbolNumber, Random random){
        if (usedNumbers.contains(symbolNumber)){
            while (usedNumbers.contains(symbolNumber)){
                symbolNumber=random.nextInt(7)+1;
            }
        }
        usedNumbers.add(symbolNumber);
        return symbolNumber;
    }
    public void correctOrder(SymbolButton symbolButton){
        int[] correctOrderArray = new int[4];
        for (int i=0 ; i < symbolButtonArrayList.size(); i++){
            correctOrderArray[i] = symbolButtonArrayList.get(i).getValue();
        }
        Arrays.sort(correctOrderArray);
        if (onButtonNumber<3){
            if (correctOrderArray[onButtonNumber]==symbolButton.getValue()){
                symbolButton.setBackground(Color.GREEN);
                symbolButton.setEnabled(false);
                onButtonNumber++;
            }
            else {
                for (int j=0; j<this.getComponents().length; j++){
                    this.getComponent(j).setBackground(Color.WHITE);
                    this.getComponent(j).setEnabled(true);
                }
                onButtonNumber=0;
                Bomb.strikePlus();
            }
        }
        else {
            for (int j=0; j<this.getComponents().length; j++){
                this.getComponent(j).setBackground(Color.GREEN);
                this.getComponent(j).setEnabled(false);
            }
        }
    }
}
