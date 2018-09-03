package learn.csia.utils;

import java.util.Scanner;

public class Stopwatch {
    private long started;

    public void start() {
        this.started = System.currentTimeMillis();
    }

    public long stop() {
        long elapsed = System.currentTimeMillis() - started;
        started = 0;
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
