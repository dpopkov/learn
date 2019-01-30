package learn.core1.ch09collections2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        InputStream inputStream = null;
        if (args.length == 0) {
            inputStream = System.in;
        } else if (args.length == 2 && "--file".equals(args[0])) {
            inputStream = new BufferedInputStream(new FileInputStream(args[1]));
        } else {
            System.out.println("Invalid arguments");
            System.exit(-1);
        }
        try (Scanner in = new Scanner(inputStream)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                totalTime += System.currentTimeMillis() - callTime;
            }
        }
        words.stream().limit(20).forEach(System.out::println);
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds");
    }
}
