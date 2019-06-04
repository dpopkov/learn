package learn.dsajg6e.ch02oop.exer;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * P-2.30
 * Inputs a document and then outputs a bar-chart plot of the frequencies of each alphabet character.
 */
public class P0230FrequenciesChart {
    public static void main(String[] args) {
        File file = null;
        if (args.length != 0) {
            file = new File(args[0]);
        } else {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
        }
        if (file != null) {
            Map<Character, Long> stats = new HashMap<>();
            try (Reader in = new BufferedReader(
                    new InputStreamReader(new BufferedInputStream(new FileInputStream(file))))) {
                char[] chars = new char[1024];
                for (int numChars; (numChars = in.read(chars)) != -1; ) {
                    process(stats, chars, numChars);
                }
                System.out.println(chart(stats));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    static void process(Map<Character, Long> stats, char[] chars, int numChars) {
        for (int i = 0; i < numChars; i++) {
            stats.merge(chars[i], 1L, (old, newValue) -> old + 1);
        }
    }

    static String chart(Map<Character, Long> stats) {
        TreeMap<Character, Long> map = new TreeMap<>(stats);
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> {
            sb.append(k);
            sb.append(" : ");
            for (int i = 0; i < v; i++) {
                sb.append('*');
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }
}
