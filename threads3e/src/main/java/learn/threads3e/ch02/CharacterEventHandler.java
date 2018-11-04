package learn.threads3e.ch02;

import java.util.Vector;

/**
 * This class fires the events when character from source is available.
 */
public class CharacterEventHandler {
    private final Vector<CharacterListener> listeners = new Vector<>();

    public void addCharacterListener(CharacterListener listener) {
        listeners.add(listener);
    }

    public void removeCharacterListener(CharacterListener listener) {
        listeners.remove(listener);
    }

    public void fireNewCharacter(CharacterSource source, int c) {
        CharacterEvent ce = new CharacterEvent(source, c);
        for (CharacterListener cl : listeners) {
            cl.newCharacter(ce);
        }
    }
}
