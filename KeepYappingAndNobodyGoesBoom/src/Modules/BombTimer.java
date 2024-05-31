package Modules;

import Frames.Bomb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Bomb timer.
 */
public class BombTimer extends JPanel{
    /**
     * The Strikes.
     */
    public ArrayList<JLabel> strikes = new ArrayList<>();
    /**
     * The Seconds.
     */
    int seconds;
    /**
     * The Minutes.
     */
    int minutes;
    /**
     * The Elapsed time.
     */
    int elapsedTime=301000;
    /**
     * The Seconds string.
     */
    String secondsString = String.format("%02d", seconds);
    /**
     * The Minutes string.
     */
    String minutesString = String.format("%02d", minutes);

    /**
     * starts a new bomb timer and shows strikes.
     */
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
                strikeAdd(Bomb.strikes);
            }
        });

        this.setLayout(new GridBagLayout());

        //Time label
        timeLabel.setText(minutesString + ":" + secondsString );
        timeLabel.setFont(new Font("Monospace",Font.PLAIN,100));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.RED);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,15,false));
        timeLabel.setPreferredSize(new Dimension(400,250));
        timeLabel.setOpaque(true);

        GridBagConstraints timeLabelConstraints = new GridBagConstraints();
        timeLabelConstraints.gridx=0;
        timeLabelConstraints.gridy=0;
        timeLabelConstraints.gridwidth=3;
        timeLabelConstraints.gridheight=2;
        timeLabelConstraints.fill=GridBagConstraints.BOTH;
        timeLabelConstraints.weightx=3;
        timeLabelConstraints.weighty=2;
        this.add(timeLabel, timeLabelConstraints);

        //Strikes
        for (int i=0;i<3;i++) {
            JLabel strike = new JLabel("X");
            strike.setFont(new Font("Monospaced", Font.BOLD, 50));
            strike.setHorizontalAlignment(JLabel.CENTER);
            strike.setVerticalAlignment(JLabel.CENTER);
            strike.setBackground(Color.BLACK);
            strike.setForeground(Color.GRAY);
            strike.setBorder(BorderFactory.createLineBorder(Color.GRAY, 10, false));
            strike.setOpaque(true);

            GridBagConstraints strikesConstraints = new GridBagConstraints();
            strikesConstraints.gridx = i;
            strikesConstraints.gridy = 3;
            strikesConstraints.gridwidth = 1;
            strikesConstraints.gridheight = 1;
            strikesConstraints.fill = GridBagConstraints.BOTH;
            strikesConstraints.weightx = 1;
            strikesConstraints.weighty = 1;
            strikes.add(strike);
            this.add(strike, strikesConstraints);
        }
        this.setBackground(new Color(0x262626));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,10,false));
        if (!timer.isRunning()){
            timer.start();
        }
    }

    /**
     * adds Strike.
     *
     * @param strike the strike
     */
    public void strikeAdd(int strike){
        if (strike>0){
            strikes.get(strike-1).setForeground(Color.RED);

        }
    }
}
