package HelpClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FilePath{
    public static ImageIcon imageIconPath(String fileName) throws IOException {
        InputStream stream = FilePath.class.getResourceAsStream(fileName);
        return new ImageIcon(ImageIO.read(stream));
    }

    public static BufferedReader textFilePath(String fileName){
        InputStream stream = FilePath.class.getResourceAsStream(fileName);
        return new BufferedReader(new InputStreamReader(stream));
    }
}