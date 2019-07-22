package learn.dsajg6e.ch07list.exer;


import java.util.*;

/**
 * The natural join of databases A and B is the list of all ordered triples (x,y,z)
 * such that the pair (x,y) is in A and the pair (y,z) is in B.
 */
public class C0755NaturalJoin<E extends Comparable<E>> {
    public List<Triple<E>> naturalJoin(List<Pair<E>> left, List<Pair<E>> right) {
        List<Triple<E>> result = new ArrayList<>();
        left.sort(Comparator.comparing(o -> o.y));
        right.sort(Comparator.comparing(o -> o.x));
        Iterator<Pair<E>> it1 = left.iterator();
        Iterator<Pair<E>> it2 = right.iterator();
        if (!it1.hasNext() || !it2.hasNext()) {
            return List.of();
        }
        Pair<E> leftPair = it1.next();
        Pair<E> rightPair = it2.next();
        while (true) {
            if (leftPair.y.equals(rightPair.x)) {
                Triple<E> triple = new Triple<>(leftPair.x, leftPair.y, rightPair.y);
                result.add(triple);
                if (!it1.hasNext() || !it2.hasNext()) {
                    break;
                }
                leftPair = it1.next();
                rightPair = it2.next();
            } else if (leftPair.y.compareTo(rightPair.x) < 0) {
                if (!it1.hasNext()) {
                    break;
                }
                leftPair = it1.next();
            } else {
                if (!it2.hasNext()) {
                    break;
                }
                rightPair = it2.next();
            }
        }
        return result;
    }

    static class Pair<E extends Comparable<E>> {
        final E x;
        final E y;

        public Pair(E x, E y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x + ", " + y + '}';
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Pair<?> pair = (Pair<?>) other;
            return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Triple<E extends Comparable<E>> extends Pair<E> {
        final E z;

        public Triple(E x, E y, E z) {
            super(x, y);
            this.z = z;
        }

        @Override
        public String toString() {
            return "{" + x + ", " + y + ", " + z + '}';
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            if (!super.equals(other)) {
                return false;
            }
            Triple<?> triple = (Triple<?>) other;
            return Objects.equals(z, triple.z);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), z);
        }
    }

}
