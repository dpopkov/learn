package learn.ijpds.ch19generics;

public class MaxUsingGenericType {
    public static <E extends Comparable<E>> E max(E o1, E o2) {
        return o1.compareTo(o2) > 0 ? o1 : o2;
    }

/*
    public static void main(String[] args) {
        System.out.println(max("String", Integer.valueOf(42)));
    }
*/
}
