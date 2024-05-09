package Frames;

import Frames.MenuButtons.*;

import javax.swing.*;
import java.awt.*;
public class Menu extends Frame{
    private JPanel mainPanel;
    private JLabel gameName;
    private ButtonPlay buttonPlay;
    private ButtonManual buttonManual;

    public Menu(){
        super();
        mainPanel = new JPanel();
        gameName = new JLabel();
        buttonPlay = new ButtonPlay("Defuse bomb");
        buttonManual = new ButtonManual("Manual");
        setLayout(null);
    }

    public void createMenu(){
        /*
        //JFrame mainFrame = new JFrame();
        JLabel label = new JLabel("Keep Yapping And Nobody Goes BOOM!");
        ImageIcon imageIcon = new ImageIcon("imageIcon.jpg");
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
        mainFrame.setTitle(label.getText());*/

        /*
        //Main panel
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1920,1080);
        */
        mainPanel();

        /*
        //Label gameName
        gameName.setText("Keep Yapping And Nobody Goes BOOM!");
        gameName.setBounds((1920/2-400),(1080/2-300),800,50);
        gameName.setFont(new Font("Calibri",Font.BOLD,50));
        gameName.setForeground(Color.WHITE);
        mainPanel.add(gameName);
         */
        gameName();

        /*
        //Button manual
        buttonManual.addActionListener(buttonManual);
        buttonManual.setBounds((1920/2-100),(1080/2-100),200,100);
        buttonManual.setFont(new Font("Calibri",Font.BOLD,25));
        buttonManual.setBackground(Color.WHITE);
        buttonManual.setFocusable(false);
        mainPanel.add(buttonManual);
         */
        buttonManual();

        /*
        //Button play
        buttonPlay.addActionListener(buttonPlay);
        buttonPlay.setBounds((1920/2-100),(1080/2-200),200,100);
        buttonPlay.setFont(new Font("Calibri",Font.BOLD,25));
        buttonPlay.setBackground(Color.WHITE);
        buttonPlay.setFocusable(false);
        mainPanel.add(buttonPlay);
         */
        buttonPlay();


        /*mainFrame.add(mainPanel);
        mainFrame.setVisible(true);*/
        add(mainPanel);
        setVisible(true);
    }

    public void mainPanel(){
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,1920,1080);
    }

    public void gameName(){
        gameName.setText("Keep Yapping And Nobody Goes BOOM!");
        gameName.setBounds((1920/2-400),(1080/2-300),800,50);
        gameName.setFont(new Font("Calibri",Font.BOLD,50));
        gameName.setForeground(Color.WHITE);
        mainPanel.add(gameName);
    }

    private void buttonManual() {
        buttonManual.addActionListener(buttonManual);
        buttonManual.setBounds((1920/2-100),(1080/2-100),200,100);
        buttonManual.setFont(new Font("Calibri",Font.BOLD,25));
        buttonManual.setBackground(Color.WHITE);
        buttonManual.setFocusable(false);
        mainPanel.add(buttonManual);
    }

    public void buttonPlay(){
        buttonPlay.addActionListener(buttonPlay);
        buttonPlay.setBounds((1920/2-100),(1080/2-200),200,100);
        buttonPlay.setFont(new Font("Calibri",Font.BOLD,25));
        buttonPlay.setBackground(Color.WHITE);
        buttonPlay.setFocusable(false);
        mainPanel.add(buttonPlay);
    }
}
