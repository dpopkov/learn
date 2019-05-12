package learn.javaio2e.ch18dialogs;

import javax.swing.*;
import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Demonstrates custom JFileChooser.
 */
public class GuiGzipper {
    private static final String GZIP_EXT = ".gz";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame parent = new JFrame();
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Please choose a file to gzip:");
            fc.setApproveButtonMnemonic('g');
            while (true) {
                int result = fc.showDialog(parent,
                        "Select a file, then press this button to gzip it");
                if (result == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    if (f == null) {
                        JOptionPane.showMessageDialog(parent, "Can only gzip files, not directories");
                    } else {
                        try (InputStream in = new BufferedInputStream(new FileInputStream(f));
                             OutputStream out = new BufferedOutputStream(new FileOutputStream(f.getAbsolutePath() + GZIP_EXT));
                             OutputStream gzOut = new GZIPOutputStream(out)) {
                            for (int c = in.read(); c != -1; c = in.read()) {
                                gzOut.write(c);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        });
    }
}
