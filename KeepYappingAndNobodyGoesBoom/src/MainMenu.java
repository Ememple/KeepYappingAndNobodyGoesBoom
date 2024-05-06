import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    Button defuserButton;
    Button manualButton;

    public MainMenu(){
        defuserButton = new Button();
        manualButton = new Button();
        defuserButton.setBounds(500, 500, 20, 10);
        manualButton.setBounds(500, 500, 20, 10);
        defuserButton.addActionListener(this);
        manualButton.addActionListener(this);
        defuserButton.setVisible(true);
        manualButton.setVisible(true);

        setTitle("Keep yapping and nobody goes BOOM!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBounds(-5,0, 1920, 1080);
        setResizable(true);
        //getContentPane().setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("icon.jpg");
        setIconImage(icon.getImage());

        add(defuserButton);
        add(manualButton);


        setVisible(true);
    }

    public void main_menu(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
