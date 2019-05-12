package learn.javaio2e.ch18dialogs;

import java.io.File;

public class JavaFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().endsWith(".java");
    }

    @Override
    public String getDescription() {
        return "Java source code (*.java)";
    }
}
