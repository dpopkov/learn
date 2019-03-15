package learn.jionio.ch12fs;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Demonstrates root directory iteration and absolute path creation.
 */
public class PathDemo2 {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("a", "b", "c");
        System.out.println(path);
        System.out.printf("Absolute: %b%n", path.isAbsolute());
        System.out.printf("Root: %s%n", path.getRoot());
        for (Path root : fs.getRootDirectories()) {
            path = fs.getPath(root.toString(), "a", "b", "c");
            System.out.println(path);
            System.out.printf("Absolute: %b%n", path.isAbsolute());
            System.out.printf("Root: %s%n", path.getRoot());
        }
    }
}
