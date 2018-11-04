package learn.threads3e.ch02;

public interface CharacterListener {
    /** Notifies the implementing listener when a new character is available. */
    void newCharacter(CharacterEvent ce);
}
