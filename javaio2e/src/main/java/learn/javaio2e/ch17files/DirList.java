package learn.javaio2e.ch17files;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Recursively lists all the files in a directory and its subdirectories.
 */
public class DirList {
    private static final int DEFAULT_INDENT = 2;

    private static final List<File> seen = new ArrayList<>();
    private static final Map<Integer, String> indents = new HashMap<>();

    private File directory;
    private int indent;

    public DirList(String name) throws IOException {
        this(new File(name), DEFAULT_INDENT);
    }

    public DirList(File directory, int indent) throws IOException {
        if (directory.isDirectory()) {
            this.directory = new File(directory.getCanonicalPath());
        } else {
            throw new IllegalArgumentException(directory + " is not a directory");
        }
        this.indent = indent;
        String spaces = indentSpaces(indent - 2);
        System.out.println(spaces + directory + File.separator);
    }

    private void list() throws IOException {
        if (!seen.contains(this.directory)) {
            seen.add(this.directory);
            String[] files = directory.list();
            if (files != null) {
                String spaces = indentSpaces(indent);
                for (String s : files) {
                    File f = new File(directory, s);
                    if (f.isFile()) {
                        System.out.println(spaces + f.getName());
                    } else if (f.isDirectory()) {
                        DirList dl = new DirList(f, indent + 2);
                        dl.list();
                    }
                }
            }
        }
    }

    private String indentSpaces(int width) {
        String s = indents.get(width);
        if (s != null) {
            return s;
        }
        s = " ".repeat(width);
        indents.put(width, s);
        return s;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java " + DirList.class.getName() + " directory");
            return;
        }
        DirList dirList = new DirList(args[0]);
        dirList.list();
    }
}
