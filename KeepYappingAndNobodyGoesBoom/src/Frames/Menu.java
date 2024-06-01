package Frames;

import Frames.MenuButtons.*;
import HelpClasses.FilePath;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The type Menu.
 */
public class Menu{
    /**
     * Creates menu.
     */
    public void createMenu() throws IOException {
        JFrame mainFrame = new JFrame();
        JLabel label = new JLabel("KeepYappingAndNobodyGoesBOOM");
        ImageIcon imageIcon;
        try {
            imageIcon = FilePath.imageIcon("/ImageIcon.jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        gameName.setText("Keep Yapping And Nobody Goes Boom");
        gameName.setBounds((1920/2-400),(1080/2-300),900,50);
        gameName.setFont(new Font("Calibri",Font.BOLD,50));
        gameName.setForeground(Color.WHITE);
        mainPanel.add(gameName);

        //Button manual
        JLayeredPane jLayeredPane = new JLayeredPane();
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

        ImageIcon backgroundImage = FilePath.imageIcon("/menu.png");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0,0,1920,1080);
        mainPanel.add(background);


        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
