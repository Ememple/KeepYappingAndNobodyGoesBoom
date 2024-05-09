package Frames;

import javax.swing.*;

public abstract class Frame extends JFrame {
    private JLabel label;
    private ImageIcon imageIcon;
    public Frame(){
        super();
        label = new JLabel("Keep Yapping And Nobody Goes BOOM!");
        imageIcon = new ImageIcon("imageIcon.jpg");
        setIconImage(imageIcon.getImage());
        setTitle(label.getText());
    }
}
