package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Dumping a Text File to the Standard Output Stream.
 */
public class DumpText {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java DumpText path");
            return;
        }
        Path path = Paths.get(args[0]);
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
