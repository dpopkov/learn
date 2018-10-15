package learn.threads3e.ch02;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int MIN_PAUSE = 1000;
    private static final int MAX_PAUSE = 5000;

    private final Random random = new Random();
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private final MinMax pauseRange;
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
        while (threadNotFinished()) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException e) {
                System.out.println("Generator interrupted when sleeping");
                break;
            }
        }
        System.out.println("random generator stopped.");
    }

    private boolean threadNotFinished() {
        boolean interrupted = isInterrupted();
        if (interrupted) {
            System.out.println("Generator is interrupted.");
        }
        if (done) {
            System.out.println("Generator is stopped by flag.");
        }
        return !(interrupted || done);
    }

    public void setDone() {
        done = true;
    }

    private int getPauseTime() {
        return Math.max(pauseRange.getMinValue(), random.nextInt(pauseRange.getMaxValue()));
    }
}
