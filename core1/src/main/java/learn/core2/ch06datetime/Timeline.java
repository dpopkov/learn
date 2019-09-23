package learn.core2.ch06datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Displays how to use the {@link Instant} and {@link Duration} classes for timing two algorithms.
 */
public class Timeline {
    public static void main(String[] args) {
        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        Duration elapsed = Duration.between(start, end);
        long millis = elapsed.toMillis();
        System.out.printf("%d milliseconds%n", millis);

        Instant start2 = Instant.now();
        runAlgorithm2();
        Instant end2 = Instant.now();
        Duration elapsed2 = Duration.between(start2, end2);
        long millis2 = elapsed2.toMillis();
        System.out.printf("%d milliseconds%n", millis2);
        boolean overTenTimesFaster = elapsed.multipliedBy(10).minus(elapsed2).isNegative();
        System.out.printf("The first algorithm is %smore than ten times faster", overTenTimesFaster ? "" : "not ");
    }

    private static void runAlgorithm2() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size)
                .boxed().collect(Collectors.toList());
        while (!IntStream.range(1, list.size()).allMatch(i -> list.get(i - 1).compareTo(list.get(i)) <= 0)) {
            Collections.shuffle(list);
        }
        System.out.println(list);
    }

    private static void runAlgorithm() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i % 100).limit(size)
                .boxed().sorted().collect(Collectors.toList());
        System.out.println(list);
    }
}
