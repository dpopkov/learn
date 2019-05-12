package learn.javaio2e.ch18dialogs;

import java.io.File;

/**
 * Encapsulates algorithm of extension filtering.
 */
public class ExtensionFilter extends javax.swing.filechooser.FileFilter {
    private final String extension;
    private final String description;

    public ExtensionFilter(String extension, String description) {
        if (extension.indexOf('.') == -1) {
            extension = "." + extension;
        }
        this.extension = extension;
        this.description = description;
    }

    @Override
    public boolean accept(File f) {
        return f.getName().endsWith(extension) || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return description + "(*" + extension + ")";
    }
}
