package Frames;
import javax.swing.*;

public abstract class Frame extends JFrame {
    private JLabel label;
    private ImageIcon imageIcon;

    public Frame(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
        setResizable(true);
        label = new JLabel("Keep Yapping And Nobody Goes BOOM!");
        imageIcon = new ImageIcon("imageIcon.jpg");
        setIconImage(imageIcon.getImage());
        setTitle(label.getText());
    }
}
