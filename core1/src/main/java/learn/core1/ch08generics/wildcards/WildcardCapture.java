package learn.core1.ch08generics.wildcards;

import learn.core1.ch08generics.Pair;

@SuppressWarnings("unused")
public class WildcardCapture {
    public static void illegalSwap(Pair<?> p) {
/*
        ? t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
*/
        throw new UnsupportedOperationException("Not implemented");
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

    /* Parameter T of swapHelper method captures the wildcard */
    public static void swap(Pair<?> p) {
        swapHelper(p);
    }
}
