package Frames;

import Frames.MenuButtons.*;

import javax.swing.*;
import java.awt.*;
public class Menu{
    public void createMenu(){
        JFrame mainFrame = new JFrame();
        JLabel label = new JLabel("Keep Talking And Nobody Explodes");
        ImageIcon imageIcon = new ImageIcon("imageIcon.jpg" );//"Symboly/Sloupec 1/1.png"
        JPanel mainPanel = new JPanel();
        JLabel gameName = new JLabel();
        ButtonPlay buttonPlay = new ButtonPlay("Defuse bomb");
        ButtonManual buttonManual = new ButtonManual("Manual");

        //Main frame
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setSize(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
        mainFrame.setResizable(true);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(imageIcon.getImage());
        mainFrame.setTitle(label.getText());

        //Main panel
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1920,1080);

        //Label gameName
        gameName.setText("Keep Talking And Nobody Explodes");
        gameName.setBounds((1920/2-400),(1080/2-300),800,50);
        gameName.setFont(new Font("Calibri",Font.BOLD,50));
        gameName.setForeground(Color.WHITE);
        mainPanel.add(gameName);

        //Button manual
        buttonManual.addActionListener(buttonManual);
        buttonManual.setBounds((1920/2-100),(1080/2-100),200,100);
        buttonManual.setFont(new Font("Calibri",Font.BOLD,25));
        buttonManual.setBackground(Color.WHITE);
        buttonManual.setFocusable(false);
        mainPanel.add(buttonManual);

        //Button bomb
        buttonPlay.addActionListener(buttonPlay);
        buttonPlay.setBounds((1920/2-100),(1080/2-200),200,100);
        buttonPlay.setFont(new Font("Calibri",Font.BOLD,25));
        buttonPlay.setBackground(Color.WHITE);
        buttonPlay.setFocusable(false);
        mainPanel.add(buttonPlay);


        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
