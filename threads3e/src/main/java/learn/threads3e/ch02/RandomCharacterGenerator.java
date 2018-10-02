package learn.threads3e.ch02;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int MIN_PAUSE = 1000;
    private static final int MAX_PAUSE = 5000;

    private final Random random = new Random();
    private final CharacterEventHandler handler = new CharacterEventHandler();

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
        for (; ; ) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getPauseTime() {
        return Math.max(MIN_PAUSE, random.nextInt(MAX_PAUSE));
    }
}
