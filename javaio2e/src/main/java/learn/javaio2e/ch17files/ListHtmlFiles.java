package learn.javaio2e.ch17files;

import java.io.File;

public class ListHtmlFiles {
    public static void main(String[] args) {
        File cwd = new File(System.getProperty("user.dir"));
        File[] htmlFiles = cwd.listFiles(new HtmlFileFilter());
        if (htmlFiles != null) {
            for (File f : htmlFiles) {
                System.out.println(f);
            }
        } else {
            System.err.println(cwd + " does not denote a directory or I/O error occurred.");
        }
    }
}
