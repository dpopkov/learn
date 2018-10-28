package learn.ijpds.ch17io.exercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class E1716CharFrequencies {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java " + E1716CharFrequencies.class.getName() + " filename");
            System.exit(1);
        }
        String path = args[0];
        Map<Character, Integer> frequencies = new HashMap<>();
        char[] buffer = new char[4 * 1024];
        try (InputStreamReader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(path)))) {
            for (int n; (n = reader.read(buffer)) != -1; ) {
                for (int i = 0; i < n; i++) {
                    frequencies.merge(buffer[i], 1, (old, value) -> old + 1);
                }
            }
        }
        frequencies.forEach((k, v) -> System.out.printf("%s (%03d) : %d%n", k, (int) k, v));
    }
}
