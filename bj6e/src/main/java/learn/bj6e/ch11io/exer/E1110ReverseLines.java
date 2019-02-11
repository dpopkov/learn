package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Replaces each line of a file with its reverse.
 */
public class E1110ReverseLines {
    public static void main(String[] args) {
        Optional<String> selected = CmdTools.getFileName(args);
        String filename = selected.orElse("txt/in2.txt");
        try {
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path);
            StringBuilder sb = new StringBuilder();
            List<String> reversed = lines.stream().map(s -> {
                sb.setLength(0);
                sb.append(s);
                sb.reverse();
                return sb.toString();
            }).collect(Collectors.toList());
            Files.write(path, reversed, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }
}
