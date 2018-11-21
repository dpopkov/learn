package learn.threads3e.ch02;

import java.util.Random;

public class RandomCharacterGenerator implements Runnable, CharacterSource {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int MIN_PAUSE = 1000;
    private static final int MAX_PAUSE = 5000;

    private final Random random = new Random();
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private final MinMax pauseRange;
    /**
     * The thread should periodically query this flag to determine if it should exit.
     */
    private boolean done = false;
    private Thread thread;

    public RandomCharacterGenerator(MinMax pauseRange) {
        this.pauseRange = pauseRange;
    }

    /* CharacterSource methods */
    @Override
    public void addCharacterListener(CharacterListener listener) {
        handler.addCharacterListener(listener);
    }

    @Override
    public void removeCharacterListener(CharacterListener listener) {
        handler.removeCharacterListener(listener);
    }

    @Override
    public void nextCharacter() {
        handler.fireNewCharacter(this, getRandomCharacter());
    }

    private char getRandomCharacter() {
        return CHARS[random.nextInt(CHARS.length)];
    }

    /* Thread method */
    @Override
    public synchronized void run() {
        while (true) {
            try {
                if (done) {
                    wait();
                } else {
                    nextCharacter();
                    wait(getPauseTime());
                }
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("random generator stopped.");
    }

    public synchronized void setDone(boolean done) {
        this.done = done;
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        if (!this.done) {
            notify();
        }
    }

    private int getPauseTime() {
        return Math.max(pauseRange.getMinValue(), random.nextInt(pauseRange.getMaxValue()));
    }
}
