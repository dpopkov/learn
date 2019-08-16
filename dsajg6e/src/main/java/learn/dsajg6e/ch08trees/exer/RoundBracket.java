package learn.dsajg6e.ch08trees.exer;

class RoundBracket implements Token {
    static final String OPENING = "(";
    static final String CLOSING = ")";

    private boolean opening;
    private final String symbol;

    public RoundBracket(String s) {
        symbol = s;
        if (OPENING.equals(s)) {
            opening = true;
        } else if (CLOSING.equals(s)) {
            opening = false;
        } else {
            throw new IllegalArgumentException("Invalid symbol for round bracket: " + s);
        }
    }

    public boolean isOpening() {
        return opening;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
