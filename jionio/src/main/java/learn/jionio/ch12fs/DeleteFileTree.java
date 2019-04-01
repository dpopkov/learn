/* Listing 12-46. Deleting a File Tree */
package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Consumer;

public class DeleteFileTree {
    private final Path fileTree;
    private final Consumer<String> out;

    public DeleteFileTree(Path fileTree, Consumer<String> out) {
        this.fileTree = fileTree;
        this.out = out;
    }

    public void delete() throws IOException {
        Files.walkFileTree(fileTree, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.deleteIfExists(file)) {
                    print("deleted regular file %s%n", file);
                } else {
                    print("couldn't delete regular file %s%n", file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (exc == null) {
                    if (Files.deleteIfExists(dir)) {
                        print("deleted directory %s%n", dir);
                    } else {
                        print("couldn't delete directory %s%n", dir);
                    }
                } else {
                    throw exc;
                }
                return FileVisitResult.CONTINUE;
            }
        });

    }

    private void print(String fmt, Path path) {
        out.accept(String.format(fmt, path.toString()));
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java DeleteFileTree path");
            return;
        }
        new DeleteFileTree(Paths.get(args[0]), System.out::println).delete();
    }
}
