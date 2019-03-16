package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Checking Paths for Various Conditions.
 */
public class CheckPath {
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.err.println("usage: CheckPath path1 [path2]");
            return;
        }
        Path path1 = Paths.get(args[0]);
        System.out.printf("Path1: %s%n", path1);
        System.out.println("Files.exists(path1) = " + Files.exists(path1));
        System.out.println("Files.notExists(path1) = " + Files.notExists(path1));
        System.out.println("Files.isDirectory(path1) = " + Files.isDirectory(path1));
        System.out.println("Files.isExecutable(path1) = " + Files.isExecutable(path1));
        try {
            System.out.println("Files.isHidden(path1) = " + Files.isHidden(path1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Files.isReadable(path1) = " + Files.isReadable(path1));
        System.out.println("Files.isRegularFile(path1) = " + Files.isRegularFile(path1));
        System.out.println("Files.isWritable(path1) = " + Files.isWritable(path1));
        if (args.length == 2) {
            Path path2 = Paths.get(args[1]);
            System.out.printf("Path2: %s%n", path2);
            try {
                System.out.println("Files.isSameFile(path1, path2) = " + Files.isSameFile(path1, path2));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
