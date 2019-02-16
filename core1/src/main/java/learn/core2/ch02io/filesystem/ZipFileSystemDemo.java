package learn.core2.ch02io.filesystem;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Demonstrates usage of zip file system.
 */
public class ZipFileSystemDemo {
    public static void main(String[] args) throws IOException {
        String zipName = "C:\\temp\\temp.zip";
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipName), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.print(attrs.isDirectory() ? "DIR : " : (attrs.isRegularFile() ? "FILE: " : "other:"));
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.out.println("I/O error: " + exc);
                return FileVisitResult.SKIP_SUBTREE;
            }
        });
    }
}
