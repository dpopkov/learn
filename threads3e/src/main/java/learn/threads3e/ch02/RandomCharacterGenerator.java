package learn.threads3e.ch02;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int MIN_PAUSE = 1000;
    private static final int MAX_PAUSE = 5000;

    private final Random random = new Random();
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private MinMax pauseRange;
    /**
     * The thread should periodically query this flag to determine if it should exit.
     */
    private volatile boolean done = false;

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
        handler.fireNewCharacter(this, CHARS[random.nextInt(CHARS.length)]);
    }

    /* Thread method */
    @Override
    public void run() {
        while (!done) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("random generator stopped.");
    }

    public void setDone() {
        done = true;
    }

    private int getPauseTime() {
        return Math.max(pauseRange.getMinValue(), random.nextInt(pauseRange.getMaxValue()));
    }
}
