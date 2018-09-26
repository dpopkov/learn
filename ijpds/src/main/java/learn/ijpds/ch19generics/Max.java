package learn.ijpds.ch19generics;

public class Max {
    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public static Comparable max(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) > 0 ? o1 : o2;
    }

    public static void main(String[] args) {
        Max.max("Welcome", 23);     // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    }
}
