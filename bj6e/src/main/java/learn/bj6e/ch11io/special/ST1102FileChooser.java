package learn.bj6e.ch11io.special;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Demonstration of {@code JFileChooser} open dialog.
 */
public class ST1102FileChooser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner in;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try {
                in = new Scanner(new BufferedInputStream(new FileInputStream(selectedFile)));
                while (in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found error: " + e);
            }
        }
    }
}
