package learn.threads3e.ch02;

public class CharacterEvent {
    private final CharacterSource source;
    private final int character;

    public CharacterEvent(CharacterSource source, int character) {
        this.source = source;
        this.character = character;
    }

    public CharacterSource getSource() {
        return source;
    }

    public int getCharacter() {
        return character;
    }
}
