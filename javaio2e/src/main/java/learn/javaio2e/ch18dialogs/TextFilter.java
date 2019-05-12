package learn.javaio2e.ch18dialogs;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A simple filename filter that accepts file ending in .txt, .java, .html and .xml;
 * all others are rejected.
 */
@SuppressWarnings("unused")
public class TextFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java")
                || name.endsWith(".txt")
                || name.endsWith(".html")
                || name.endsWith(".xml");
    }
}
