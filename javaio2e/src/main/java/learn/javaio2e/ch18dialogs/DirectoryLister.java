package learn.javaio2e.ch18dialogs;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/**
 * Lets the user pick a directory and lists the contents of that directory.
 */
public class DirectoryLister {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fc.showOpenDialog(new JFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                File dir = fc.getSelectedFile();
                String[] contents = dir.list();
                if (contents != null) {
                    for (String item : contents) {
                        System.out.println(item);
                    }
                }
            }
            System.exit(0);
        });
    }
}
