package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Reads a file, removes any blank lines at the beginning or end of the file,
 * and writes the remaining lines back to the same file.
 */
public class E1103TrimBlankLines {
    public static void main(String[] args) {
        Optional<String> selected = CmdTools.getFileName(args);
        if (selected.isEmpty()) {
            System.out.println("Needs a filename of file to trim.");
            return;
        }
        String filename = selected.get();
        try {
            trimBlankLines(filename);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }

    private static void trimBlankLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        boolean isContent = false;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.isBlank() || isContent) {
                    isContent = true;
                    lines.add(line);
                }
            }
        }
        for (int i = lines.size() - 1; i >= 0; i--) {
            if (lines.get(i).isBlank()) {
                lines.remove(i);
            } else {
                break;
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
