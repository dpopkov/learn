package learn.dsajg6e.tools;

public class StopWatch {
    private long startTime;
    private long elapsed;
    private boolean started;

    public void start() {
        if (started) {
            throw new IllegalStateException("Not stopped yet");
        }
        elapsed = 0;
        startTime = System.currentTimeMillis();
        started = true;
    }

    public void stop() {
        if (!started) {
            throw new IllegalStateException("Not started yet");
        }
        elapsed = System.currentTimeMillis() - startTime;
        started = false;
    }

    public long getElapsed() {
        if (started) {
            throw new IllegalStateException("Not stopped yet");
        }
        return elapsed;
    }
}
