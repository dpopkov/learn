package learn.ijpds2nd.ch08multiarrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Listing 8.2 */
public class GradeExam {

    private static final int NUM_ROWS = 8;

    public static void main(String[] args) {
//        reformatInput();
        char[][] answers = {{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
        {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
        {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
        {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        for (int i = 0; i < answers.length; i++) {
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j]) {
                    correctCount++;
                }
            }
            System.out.println("Student " + i + "'s correct count is " + correctCount);
        }
    }

    @SuppressWarnings("unused")
    private static void reformatInput() throws IOException {
        String filename = "in-grades.txt";
        Path path = Paths.get("");
        Path directory = path.resolve("txt").resolve("input");
        path = directory.resolve(filename);
        System.out.println(path.toAbsolutePath());
        System.out.println(Files.exists(path));
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).trim());
        }
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("{")) {
                continue;
            }
            int j;
            if (line.endsWith("},") || line.endsWith("};")) {
                j = i - NUM_ROWS * 2;
            } else {
                j = i - NUM_ROWS;
            }
            String prefix = lines.get(j);
            String added = prefix + " " + lines.get(i);
            lines.set(j, added);
        }
        Path target = directory.resolve(filename + ".out.txt");
        List<String> outputLines = new ArrayList<>();
        for (int i = 0; i < NUM_ROWS; i++) {
            outputLines.add(lines.get(i).trim());
        }
        Files.write(target, outputLines);
    }
}
