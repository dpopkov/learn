package learn.javaio2e.ch18dialogs;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Opens file dialog and writes the contents of the selected file.
 */
public class FileTyper {
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try {
            File f = getFile();
            if (f == null) {
                return;
            }
            in = new FileInputStream(f);
            for (int c = in.read(); c != -1; c = in.read()) {
                System.out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        // Work around AWT non-daemon thread bug.
        System.exit(0);
    }

    private static File getFile() {
        // dummy frame, never shown
        Frame parent = new Frame();
        FileDialog fd = new FileDialog(parent, "Please choose a file:", FileDialog.LOAD);
        fd.setVisible(true);
        // Program stops here until user selects a file or cancels.
        String dir = fd.getDirectory();
        String file = fd.getFile();
        parent.dispose();
        fd.dispose();
        if (dir == null || file == null) {
            return null;
        }
        return new File(dir, file);
    }
}
