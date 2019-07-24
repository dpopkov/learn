package learn.dsajg6e.ch07list.proj.p0760;

/** Rank of card. */
@SuppressWarnings("unused")
public enum Rank {
    R2("2"),
    R3("3"),
    R4("4"),
    R5("5"),
    R6("6"),
    R7("7"),
    R8("8"),
    R9("9"),
    R10("10"),
    J("Jack"),
    Q("Queen"),
    K("King"),
    A("Ace");

    private final String name;

    Rank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
