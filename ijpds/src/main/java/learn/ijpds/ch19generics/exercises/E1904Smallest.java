package learn.ijpds.ch19generics.exercises;

public class E1904Smallest {
    private static <T extends Comparable<T>> T smallest(E1903Pair<T> pair) {
        T first = pair.getFirst();
        T second = pair.getSecond();
        return first.compareTo(second) < 0 ? first : second;
    }

    public static void main(String[] args) {
        E1903Pair<String> p = new E1903Pair<>("aaa", "bbb");
        System.out.println(smallest(p));
    }
}
