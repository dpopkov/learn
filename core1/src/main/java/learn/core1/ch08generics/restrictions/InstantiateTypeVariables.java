package learn.core1.ch08generics.restrictions;

import learn.core1.ch08generics.Pair;

import java.util.function.Supplier;

public class InstantiateTypeVariables {
    public static void main(String[] args) {
        Pair<String> ps = makePair();
        ps.setFirst("first");
        ps.setSecond("second");
        System.out.println(ps);

        Pair<Integer> pi = makePair(22);
        System.out.println(pi);

        Pair<String> ps2 = makePair(String::new);
        System.out.println(ps2);
    }

    /**
     * Makes pair containing default values of type represented by supplied constructor.
     */
    public static <T> Pair<T> makePair(Supplier<T> constructor) {
        return new Pair<>(constructor.get(), constructor.get());
    }

    /**
     * Makes pair that contains supplied element.
     * This method doesn't need the actual type of parameter.
     */
    public static <T> Pair<T> makePair(T element) {
        Pair<T> p = new Pair<>();
        p.setFirst(element);
        p.setSecond(element);
        return p;
    }

    /** Makes empty pair. This method doesn't need the actual type of parameter.*/
    public static <T> Pair<T> makePair() {
        return new Pair<>();
    }
}
