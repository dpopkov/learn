package learn.javaio2e.ch17files;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Filters out everything that is not an HTML file.
 */
@SuppressWarnings("unused")
public class HtmlFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".html") || name.endsWith(".htm");
    }
}
