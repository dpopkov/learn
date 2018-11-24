package learn.core1.ch08generics.bounds;

import java.util.*;

/**
 * Demonstrates how to use multiple bounding types separated by ampersand (&).
 * Example: {@code <T extends Comparable & Runnable>}
 */
public class MultipleBoundsDemo {
    @SafeVarargs
    private static <T extends Comparable & Runnable> void processOrdered(T... runners) {
        PriorityQueue<T> pq = new PriorityQueue<>(Arrays.asList(runners));
        while (!pq.isEmpty()) {
            pq.remove().run();
        }
    }

    public static void main(String[] args) {
        Runner r1 = new Runner(1, "First");
        Runner r2 = new Runner(2, "Second");
        Runner r3 = new Runner(3, "Third");
        processOrdered(r3, r1, r2);
    }

    private static class Runner implements Comparable<Runner>, Runnable {
        private int priority;
        private String message;

        public Runner(int priority, String message) {
            this.priority = priority;
            this.message = message;
        }

        @Override
        public int compareTo(Runner o) {
            return Integer.compare(priority, o.priority);
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }
}
