package learn.threads3e.ch05atomic;

import learn.threads3e.ch02.CharacterEventHandler;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;
import learn.threads3e.ch02.MinMax;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int MIN_PAUSE = 1000;
    private static final int MAX_PAUSE = 5000;

    private final Random random = new Random();
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private final MinMax pauseRange;
    private AtomicBoolean done = new AtomicBoolean(true);

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
        while (true) {
            try {
                if (done.get()) {
                    Thread.sleep(100);
                } else {
                    nextCharacter();
                    Thread.sleep(getPauseTime());
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void setDone(boolean done) {
        this.done.set(done);
    }

    private int getPauseTime() {
        return Math.max(pauseRange.getMinValue(), random.nextInt(pauseRange.getMaxValue()));
    }
}
