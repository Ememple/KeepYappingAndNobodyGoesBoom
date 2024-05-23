package Modules;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Symbols extends JPanel {
    ArrayList<Integer> usedNumbers = new ArrayList<>();
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
            JButton jButton= new JButton();
            jButton.setFocusable(false);
            int symbolNumber = random.nextInt(7)+1;
            String symbol="";
            switch (checkSymbol(symbolNumber,random)){
                case 1:
                    symbol="/1.png";
                    break;
                case 2:
                    symbol="/2.png";
                    break;
                case 3:
                    symbol="/3.png";
                    break;
                case 4:
                    symbol="/4.png";
                    break;
                case 5:
                    symbol="/5.png";
                    break;
                case 6:
                    symbol="/6.png";
                    break;
                case 7:
                    symbol="/7.png";
                    break;
            }
            String pngPath=columnString+symbol;
            jButton.setBackground(Color.WHITE);
            jButton.setIcon(new ImageIcon(pngPath));
            jButton.setBorder(BorderFactory.createLineBorder(new Color(0xA9A9A9), 2, false));
            this.add(jButton);
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
}
