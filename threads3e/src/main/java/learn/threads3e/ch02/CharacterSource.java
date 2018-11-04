package learn.threads3e.ch02;

public interface CharacterSource {
    void addCharacterListener(CharacterListener listener);
    void removeCharacterListener(CharacterListener listener);
    /** Causes the next character to be produced. */
    void nextCharacter();
}
