package learn.csia.utils;

import java.util.Scanner;

public class Stopwatch {
    private long started;
    private long elapsed;
    private boolean running;

    public long getElapsed() {
        if (running) {
            throw new IllegalStateException("Stopwatch is not stopped yet.");
        }
        return elapsed;
    }

    public void start() {
        if (running) {
            throw new IllegalStateException("Stopwatch is started already.");
        }
        started = System.currentTimeMillis();
        running = true;
    }

    public long stop() {
        if (!running) {
            throw new IllegalStateException("Stopwatch is not started yet.");
        }
        elapsed = System.currentTimeMillis() - started;
        running = false;
        return elapsed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stopwatch sw = new Stopwatch();
        sw.start();
        System.out.print("Wait a few seconds and press Enter...");
        in.nextLine();
        long elapsed = sw.stop();
        System.out.printf("%d ms elapsed%n", elapsed);
    }
}
