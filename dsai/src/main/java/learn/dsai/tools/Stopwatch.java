package learn.dsai.tools;

public class Stopwatch {
    private long started;
    private long elapsed;
    private boolean running;

    public void start() {
        if (running) {
            throw new IllegalStateException("Stopwatch is still running");
        }
        started = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        if (!running) {
            throw new IllegalStateException("Stopwatch is not running");
        }
        elapsed = System.currentTimeMillis() - started;
        running = false;
    }

    public long getElapsed() {
        return elapsed;
    }
}
