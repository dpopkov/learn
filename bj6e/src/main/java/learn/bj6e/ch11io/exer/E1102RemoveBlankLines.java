package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Reads a file, removes any blank lines,
 * and writes the non-blank lines back to the same file.
 */
public class E1102RemoveBlankLines {
    public static void main(String[] args) {
        Optional<String> selected = CmdTools.getFileName(args);
        if (selected.isEmpty()) {
            System.out.println("Needs a filename");
            return;
        }
        String filename = selected.get();
        try {
            removeBlankLines(filename);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    private static void removeBlankLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.isBlank()) {
                    lines.add(line);
                }
            }
        }
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))) {
            for (String line : lines) {
                out.write(line);
                out.newLine();
            }
        }
    }
}
