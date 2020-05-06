package learn.ijpds2nd.ch08multiarrays.exer;

class Pair <T> {
    private final T p1;
    private final T p2;

    public Pair(T p1, T p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public T getP1() {
        return p1;
    }

    public T getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "Pair{p1=" + p1 + ", p2=" + p2 + '}';
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return p1.equals(pair.p1) && p2.equals(pair.p2)
                || p2.equals(pair.p1) && p1.equals(pair.p2);
    }

    @Override
    public int hashCode() {
        return p1.hashCode() + p2.hashCode();
    }
}
