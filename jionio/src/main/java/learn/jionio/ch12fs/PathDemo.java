package learn.jionio.ch12fs;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Constructs a path and accesses its name elements.
 */
public class PathDemo {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("a", "b", "c");
        System.out.println(path);
        System.out.printf("File name: %s%n", path.getFileName());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }
        System.out.printf("Parent: %s%n", path.getParent());
        System.out.printf("Root: %s%n", path.getRoot());
        System.out.printf("SubPath [0, 2): %s%n", path.subpath(0, 2));
    }
}
