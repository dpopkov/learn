/* Listing 12-48. Streaming and Outputting the Paths of All Files That Match a File Extension */
package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ListByExtensionDemo {
    private final BiPredicate<Path, BasicFileAttributes> predicate;

    public ListByExtensionDemo(String extension) {
        predicate = (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().endsWith(extension);
    }

    public void list(Path dir, Consumer<Path> out) throws IOException {
        try (Stream<Path> stream = Files.find(dir, 1, predicate)) {
            stream.forEach(out);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java ListByExtensionDemo dir-path ext");
            return;
        }
        final Path dir = Paths.get(args[0]);
        final String extension = args[1];
        new ListByExtensionDemo(extension).list(dir, System.out::println);
    }
}
