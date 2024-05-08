import javax.swing.*;

public class DefuseFrame extends JFrame {
    public DefuseFrame(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
        setResizable(true);
        setTitle("Keep Yapping And Nobody Goes BOOM!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("ImageIcon.jpg");
        setIconImage(imageIcon.getImage());

        setVisible(true);
    }

    
}
