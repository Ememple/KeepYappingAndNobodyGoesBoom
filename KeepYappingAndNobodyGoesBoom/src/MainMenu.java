import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    Button defuserButton;
    Button manualButton;

    public MainMenu(){


        setTitle("Keep yapping and nobody goes BOOM!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBounds(-5,0, 1920, 1080);
        setResizable(true);
        //getContentPane().setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("icon.jpg");
        setIconImage(icon.getImage());

        defuserButton = new Button();
        manualButton = new Button();
        defuserButton.setBounds(getWidth()/2, getHeight()/2, 200, 100);
        manualButton.setBounds(getWidth()/2, getHeight()/2, 200, 100);
        defuserButton.addActionListener(this);
        manualButton.addActionListener(this);
        defuserButton.setText("DEFUSER");
        manualButton.setText("MANUAL");
        defuserButton.setVisible(true);
        manualButton.setVisible(true);

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
