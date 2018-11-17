package learn.threads3e.ch03synch;

import learn.threads3e.ch02.CharacterEvent;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;

import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScoreLabel extends JLabel implements CharacterListener {
    private static final int TYPED_CORRECTLY = -1;

    private volatile int score = 0;
    private int charBuffer = TYPED_CORRECTLY;
    private CharacterSource generator = null, typist = null;
    private Lock scoreLock = new ReentrantLock();

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = generator;
        this.typist = typist;
        if (generator != null) {
            generator.addCharacterListener(this);
        }
        if (typist != null) {
            typist.addCharacterListener(this);
        }
    }

    public ScoreLabel() {
        this(null, null);
    }

    @SuppressWarnings("Duplicates")
    public void resetGenerator(CharacterSource newGenerator) {
        try {
            scoreLock.lock();
            if (generator != null) {
                generator.removeCharacterListener(this);
            }
            generator = newGenerator;
            if (generator != null) {
                generator.addCharacterListener(this);
            }
        } finally {
            scoreLock.unlock();
        }
    }

    @SuppressWarnings("Duplicates")
    public void resetTypist(CharacterSource newTypist) {
        try {
            scoreLock.lock();
            if (typist != null) {
                typist.removeCharacterListener(this);
            }
            typist = newTypist;
            if (typist != null) {
                typist.addCharacterListener(this);
            }
        } finally {
            scoreLock.unlock();
        }
    }

    public synchronized void resetScore() {
        try {
            scoreLock.lock();
            score = 0;
            charBuffer = TYPED_CORRECTLY;
            setScore();
        } finally {
            scoreLock.unlock();
        }
    }

    private void setScore() {
        /* This method will be explained later in chapter 7. */
        SwingUtilities.invokeLater(() -> setText(Integer.toString(score)));
    }

    @Override
    public void newCharacter(CharacterEvent ce) {
            if (ce.getSource() == generator) {
                try {
                    scoreLock.lock();
                    /* If previous character not typed correctly: 1-point penalty. */
                    if (charBuffer != TYPED_CORRECTLY) {
                        score--;
                        setScore();
                    }
                    charBuffer = ce.getCharacter();
                } finally {
                    scoreLock.unlock();
                }
            } else {
                try {
                    scoreLock.lock();
                    /* If character does not match: 1-point penalty. */
                    if (charBuffer != ce.getCharacter()) {
                        score--;
                    } else {
                        score++;
                        charBuffer = TYPED_CORRECTLY;
                    }
                    setScore();
                } finally {
                    scoreLock.unlock();
                }
            }
    }
}
