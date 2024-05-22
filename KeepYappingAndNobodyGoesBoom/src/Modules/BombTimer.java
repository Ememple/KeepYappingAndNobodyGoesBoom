package Modules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BombTimer extends JPanel{
    int seconds;
    int minutes;
    int elapsedTime=301000;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    public BombTimer() {
        JLabel timeLabel = new JLabel();

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elapsedTime!=0){
                    elapsedTime = elapsedTime - 100;
                    minutes = (elapsedTime / 60000) % 60;
                    seconds = (elapsedTime / 1000) % 60;

                    minutesString = String.format("%02d", minutes);
                    secondsString = String.format("%02d", seconds);

                    timeLabel.setText(minutesString + ":" + secondsString );

                }
                else {
                    System.exit(0);
                }
            }
        });
        //Time label
        timeLabel.setText(minutesString + ":" + secondsString );
        timeLabel.setFont(new Font("Calibri",Font.BOLD,100));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.RED);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,15,false));
        timeLabel.setPreferredSize(new Dimension(400,250));
        timeLabel.setOpaque(true);



        this.setLayout(new GridBagLayout());
        this.add(timeLabel);
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,10,false));
        if (!timer.isRunning()){
            timer.start();
        }
    }
}
