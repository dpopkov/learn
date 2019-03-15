package learn.jionio.ch02file;

import java.io.File;

/**
 * Checks a File's or Directory's permissions.
 */
public class Permissions {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Permissions path");
            return;
        }
        File file = new File(args[0]);
        System.out.println("Checking permissions for " + args[0]);
        System.out.println("  file.canExecute() = " + file.canExecute());
        System.out.println("  file.canRead() = " + file.canRead());
        System.out.println("  file.canWrite() = " + file.canWrite());
    }
}
