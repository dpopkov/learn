package learn.dsajg6e.ch07list.proj;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

public class P0761TextEditor {
    private static final char CURSOR = '|';

    private final LinkedPositionalList<Character> characters;
    private Position<Character> current;

    public P0761TextEditor(String text) {
        characters = new LinkedPositionalList<>();
        for (char ch : text.toCharArray()) {
            characters.addLast(ch);
        }
        characters.addFirst(CURSOR);
        current = characters.first();
    }

    public void left() {
        Position<Character> before = characters.before(current);
        if (before != null) {
            var newCurrent = characters.addBefore(before, CURSOR);
            characters.remove(current);
            current = newCurrent;
        }
    }

    public void right() {
        Position<Character> after = characters.after(current);
        if (after != null) {
            var newCurrent = characters.addAfter(after, CURSOR);
            characters.remove(current);
            current = newCurrent;
        }
    }

    public void insert(char ch) {
        characters.addAfter(current, ch);
    }

    public void delete() {
        Position<Character> after = characters.after(current);
        characters.remove(after);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character ch : characters) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
