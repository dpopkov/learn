package learn.threads3e.ch02;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

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
    public void run() {
        try {
            lock.lock();
            while (true) {
                try {
                    if (done) {
                        condition.await();
                    } else {
                        nextCharacter();
                        condition.await(getPauseTime(), TimeUnit.MILLISECONDS);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("Duplicates")
    public void setDone(boolean done) {
        try {
            lock.lock();
            this.done = done;
            if (thread == null) {
                thread = new Thread(this);
                thread.start();
            }
            if (!this.done) {
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    private int getPauseTime() {
        return Math.max(pauseRange.getMinValue(), random.nextInt(pauseRange.getMaxValue()));
    }
}
