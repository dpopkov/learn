package learn.ijpds2nd.tools;

public class NanoStopWatch {
    private long started;
    private long stopped;
    private boolean running;

    public void start() {
        if (running) {
            throw new IllegalStateException("This stopwatch is running already");
        }
        started = System.nanoTime();
        running = true;
    }

    /** Stops and returns elapsed time in nanoseconds. */
    public long stop() {
        if (!running) {
            throw new IllegalStateException("This stopwatch is not started yet");
        }
        stopped = System.nanoTime();
        running = false;
        return elapsed();
    }

    /** Returns elapsed time in nanoseconds. */
    public long elapsed() {
        if (running) {
            throw new IllegalStateException("This stopwatch is not stopped yet");
        }
        return stopped - started;
    }
}
