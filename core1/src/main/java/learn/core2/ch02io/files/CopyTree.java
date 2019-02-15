package learn.core2.ch02io.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Copies one directory tree to another directory.
 */
public class CopyTree {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java " + CopyTree.class.getName() + " sourceDir targetDir");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        if (!Files.exists(target)) {
            Files.createDirectories(target);
        }
        if (!Files.isDirectory(target)) {
            System.out.println(target + " is not a directory");
            return;
        }
        try (Stream<Path> ps = Files.walk(source)) {
            ps.forEach(p -> {
                try {
                    Path t = target.resolve(source.relativize(p));
                    if (Files.isDirectory(p)) {
                        Files.createDirectory(t);
                    } else {
                        Files.copy(p, t);
                    }
                } catch (IOException e) {
                    System.out.println("I/O error when processing target entry: " + e);
                }
            });
            System.out.println("Tree \"" + source + "\" copied to \"" + target + "\"");
        } catch (IOException e) {
            System.out.println("I/O error when walking tree: " + e);
        }
    }
}
