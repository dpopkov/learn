package learn.javaio2e.ch18dialogs;

import javax.swing.*;
import java.io.*;

/**
 * Demonstrates JFileChooser usage to select a file.
 */
public class JFileTyper {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(new JFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file != null) {
                    try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
                        for (int c = in.read(); c != -1; c = in.read()) {
                            System.out.write(c);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.exit(0);
        });
    }
}
