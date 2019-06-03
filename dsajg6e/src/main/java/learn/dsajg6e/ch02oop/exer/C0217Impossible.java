package learn.dsajg6e.ch02oop.exer;

public class C0217Impossible {
    public static void main(String[] args) {
        System.out.println("start main()");
        callImpossible();
        System.out.println("finish main()");
    }

    private static void callImpossible() {
        System.out.println("start callImpossible");
        if (Math.random() < 0) {
            System.out.println("impossible");
        }
        System.out.println("finish callImpossible");
    }
}
