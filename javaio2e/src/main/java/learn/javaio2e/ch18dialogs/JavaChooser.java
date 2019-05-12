package learn.javaio2e.ch18dialogs;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Demonstrates usage of choosable JavaFilter in JFileChooser to select a file.
 */
public class JavaChooser {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            JFileChooser chooser = new JFileChooser();
            chooser.addChoosableFileFilter(new JavaFilter());
            int result = chooser.showOpenDialog(new JFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file != null) {
                    writeToSystemOut(file);
                }
            }
            System.exit(0);
        });
    }

    private static void writeToSystemOut(File file) {
        try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            for (int c = in.read(); c != -1; c = in.read()) {
                System.out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
