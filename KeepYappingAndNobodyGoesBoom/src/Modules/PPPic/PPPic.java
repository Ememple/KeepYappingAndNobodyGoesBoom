package Modules.PPPic;

import HelpClasses.FilePath;

import javax.swing.*;
import java.io.IOException;

public class PPPic extends JLabel {
    private String fileName;

    public PPPic(String fileName) throws IOException {
        super();
        this.fileName = fileName;
        setIcon(FilePath.imageIcon(this.fileName));
        setVisible(true);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}