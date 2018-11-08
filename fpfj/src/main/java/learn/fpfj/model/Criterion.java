package learn.fpfj.model;

@FunctionalInterface
public interface Criterion<E> {
    boolean test(E e);

    default Criterion<E> negate() {
        return t -> !this.test(t);
    }

    default Criterion<E> and(Criterion<E> second) {
        return t -> this.test(t) && second.test(t);
    }

    default Criterion<E> or(Criterion<E> second) {
        return t -> this.test(t) || second.test(t);
    }
}
