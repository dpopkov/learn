package learn.javaio2e.ch17files;

import java.io.File;
import java.io.FileFilter;

public class HtmlFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".html") || pathname.getName().endsWith(".htm");
    }
}
