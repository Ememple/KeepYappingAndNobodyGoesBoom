import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🤓");

        JFrame frame = new JFrame();
        frame.setTitle("Keep yapping and nobody goes BOOM!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("icon.jpeg");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(Color.BLACK);

        JPanel blue_panel = new JPanel();
        blue_panel.setBackground(Color.BLUE);
        blue_panel.setBounds(0,0, 1920/6, 1080/6);


        frame.add(blue_panel);
    }
}