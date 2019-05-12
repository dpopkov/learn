package learn.javaio2e.ch18dialogs;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Filter that can be configured with different extensions.
 */
@SuppressWarnings("unused")
public class ExtensionFilenameFilter implements FilenameFilter {
    private final List<String> extensions = new ArrayList<>();

    public ExtensionFilenameFilter(String extension) {
        addExtension(extension);
    }

    public void addExtension(String extension) {
        if (extension.indexOf('.') != -1) {
            extension = extension.substring(extension.lastIndexOf('.') + 1);
        }
        extensions.add(extension);
    }

    @Override
    public boolean accept(File dir, String name) {
        String ext = name.substring(name.lastIndexOf('.') + 1);
        return extensions.contains(ext);
    }
}
