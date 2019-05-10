package learn.javaio2e.ch17files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * A character-mode program that lists all the available information about files named on the command line.
 */
public class FileSpy {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java " + FileSpy.class.getName() + " file1 [file2...]");
            return;
        }
        for (String name : args) {
            File file = new File(name);
            if (file.exists()) {
                System.out.println("file.getName() = " + file.getName());
                System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
                try {
                    System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
                } catch (IOException e) {
                    System.out.println("Could not determine the canonical path.");
                }
                String parent = file.getParent();
                if (parent != null) {
                    System.out.println("parent = " + parent);
                }
                if (file.canWrite()) {
                    System.out.println(file.getName() + " is writable.");
                }
                if (file.canRead()) {
                    System.out.println(file.getName() + " is readable");
                }
                if (file.isFile()) {
                    System.out.println(file.getName() + " is a file");
                } else if (file.isDirectory()) {
                    System.out.println(file.getName() + " is a directory");
                } else {
                    System.out.println(file.getName() + " is not a file nor a directory");
                }
                if (file.isAbsolute()) {
                    System.out.println(file.getName() + " is an absolute path");
                } else {
                    System.out.println(file.getName() + " is not an absolute path");
                }
                long lm = file.lastModified();
                if (lm != 0) {
                    System.out.println("Last modified at " + new Date(lm));
                }
                long length = file.length();
                if (length != 0) {
                    System.out.println(file.getName() + " is " + length + " bytes long.");
                }
            } else {
                System.out.println("I'm sorry. I can't find the file " + file);
            }
        }
    }
}
