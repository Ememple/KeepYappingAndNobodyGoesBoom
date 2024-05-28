package Modules.PPPic;

import javax.swing.*;
import java.awt.*;

public class PPPic extends JLabel {
    private String fileName;

    public PPPic(String fileName){
        super();
        this.fileName = fileName;
        setIcon(new ImageIcon(this.fileName));
        setVisible(true);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}