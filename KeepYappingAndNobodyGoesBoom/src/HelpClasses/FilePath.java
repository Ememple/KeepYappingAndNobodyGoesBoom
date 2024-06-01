package HelpClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Helps with getting images and text files from external files.
 */
public class FilePath{
    /**
     * Gets an external image.
     * @param fileName
     * @return
     * @throws IOException
     */
    public static ImageIcon imageIcon(String fileName) throws IOException {
        InputStream stream = FilePath.class.getResourceAsStream(fileName);
        return new ImageIcon(ImageIO.read(stream));
    }

    /**
     * Gets an external text file.
     * @param fileName
     * @return
     */
    public static BufferedReader textFile(String fileName){
        InputStream stream = FilePath.class.getResourceAsStream(fileName);
        return new BufferedReader(new InputStreamReader(stream));
    }
}