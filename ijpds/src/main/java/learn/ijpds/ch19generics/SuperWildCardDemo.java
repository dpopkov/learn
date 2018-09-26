package learn.ijpds.ch19generics;

public class SuperWildCardDemo {
    public static void main(String[] args) {
        GenericStack<String> st1 = new GenericStack<>();
        GenericStack<Object> st2 = new GenericStack<>();
        st2.push("Java");
        st2.push(2);
        st1.push("Sun");
        add(st1, st2);
        System.out.println(st2);
    }

    private static <T> void add(GenericStack<T> source, GenericStack<? super T> dest) {
        while(!source.isEmpty()) {
            dest.push(source.pop());
        }
    }
}
