package learn.jionio.ch02file;

import java.io.File;
import java.util.Date;

/**
 * Obtains File/Directory information.
 */
public class FileDirectoryInfo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileDirectoryInfo path");
            return;
        }
        File file = new File(args[0]);
        System.out.println("About " + file + ":");
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isHidden() = " + file.isHidden());
        System.out.println("new Date(file.lastModified()) = " + new Date(file.lastModified()));
        System.out.println("file.length() = " + file.length());
    }
}
