package learn.jionio.ch12fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Dumping a Text File to the Standard Output Stream using BufferedReader.
 */
public class DumpText2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java DumpText2 path");
            return;
        }
        Path path = Paths.get(args[0]);
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
