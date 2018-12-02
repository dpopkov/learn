package learn.threads3e.ch03synch;

import learn.threads3e.ch02.CharacterEvent;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ScoreLabel extends JLabel implements CharacterListener {
    private static final int TYPED_CORRECTLY = -1;

    private AtomicInteger score = new AtomicInteger(0);
    private AtomicInteger charBuffer = new AtomicInteger(TYPED_CORRECTLY);
    private AtomicReference<CharacterSource> generator;
    private AtomicReference<CharacterSource> typist;

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = new AtomicReference<>(generator);
        this.typist = new AtomicReference<>(typist);
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
        if (newGenerator != null) {
            newGenerator.addCharacterListener(this);
        }
        CharacterSource oldGenerator = generator.getAndSet(newGenerator);
        if (oldGenerator != null) {
            oldGenerator.removeCharacterListener(this);
        }
    }

    @SuppressWarnings("Duplicates")
    public void resetTypist(CharacterSource newTypist) {
        if (newTypist != null) {
            newTypist.addCharacterListener(this);
        }
        CharacterSource oldTypist = typist.getAndSet(newTypist);
        if (oldTypist != null) {
            oldTypist.removeCharacterListener(this);
        }
    }

    public void resetScore() {
        score.set(0);
        charBuffer.set(TYPED_CORRECTLY);
        setScore();
    }

    private void setScore() {
        /* This method will be explained later in chapter 7. */
        SwingUtilities.invokeLater(() -> setText(Integer.toString(score.get())));
    }

    @Override
    public void newCharacter(CharacterEvent ce) {
        if (ce.getSource() == generator.get()) {
            newGeneratorCharacter(ce.getCharacter());
        } else if (ce.getSource() == typist.get()) {
            newTypistCharacter(ce.getCharacter());
        }
    }

    private void newGeneratorCharacter(int character) {
        /* If previous character not typed correctly: 1-point penalty. */
        int oldChar = charBuffer.getAndSet(character);
        if (oldChar != TYPED_CORRECTLY) {
            score.decrementAndGet();
            setScore();
        }
    }

    private void newTypistCharacter(int character) {
        /* If character does not match: 1-point penalty. */
        while (true) {
            int oldChar = charBuffer.get();
            if (oldChar != character) {
                score.decrementAndGet();
                break;
            } else if (charBuffer.compareAndSet(oldChar, TYPED_CORRECTLY)) {
                score.incrementAndGet();
                break;
            }
        }
        setScore();
    }
}
