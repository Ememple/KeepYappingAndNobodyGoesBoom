package Modules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BombTimer extends JPanel{
    int seconds;
    int minutes;
    int elapsedTime=300000;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);

    public BombTimer() {
        JLabel timeLabel = new JLabel();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elapsedTime!=0){
                    elapsedTime = elapsedTime - 1000;
                    minutes = (elapsedTime / 60000) % 60;
                    seconds = (elapsedTime / 1000) % 60;

                    minutesString = String.format("%02d", minutes);
                    secondsString = String.format("%02d", seconds);

                    timeLabel.setText(minutesString + ":" + secondsString );

                }
            }
        });

        timeLabel.setText(minutesString + ":" + secondsString );
        timeLabel.setFont(new Font("Calibri",Font.BOLD,40));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.RED);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setBounds(100,100,120,80);

        Label label = new Label();
        label.setBounds(95,95,130,90);
        label.setBackground(Color.GRAY);
        this.add(timeLabel);
        this.add(label);

        this.setSize(400,400);
        this.setLayout(null);
        this.setBackground(Color.BLUE);
        if (!timer.isRunning()){
            timer.start();
        }
    }
}
