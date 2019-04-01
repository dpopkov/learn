/* Listing 12-47. Moving a File Tree */
package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MoveFileTree {
    private final Path srcPath;
    private final Path destPath;

    public MoveFileTree(Path srcPath, Path destPath) {
        this.srcPath = srcPath;
        this.destPath = destPath;
    }

    public void move() throws IOException {
        Files.walkFileTree(srcPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path target = destPath.resolve(srcPath.relativize(dir));
                Files.copy(dir, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path target = destPath.resolve(srcPath.relativize(file));
                Files.move(file, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (exc == null) {
                    Files.delete(dir);
                } else {
                    throw exc;
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java MoveFileTree source-path destination-path");
            return;
        }
        new MoveFileTree(Paths.get(args[0]), Paths.get(args[1])).move();
    }
}
