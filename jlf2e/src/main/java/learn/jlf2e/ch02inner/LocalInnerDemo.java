/* 2-8. Testing a Local Inner class. */
package learn.jlf2e.ch02inner;

public class LocalInnerDemo {
    public static void main(String[] args) {
        RandomInteger rTop = new RandomInteger();
        System.out.println("Random integers using a top-level class:");
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());
        System.out.println(rTop.getValue());

        OuterForRandomLocal outer = new OuterForRandomLocal();
        RandomInteger rLocal = outer.getRandomInteger();
        System.out.println("\nRandom integers using a local inner class:");
        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());
        System.out.println(rLocal.getValue());
    }
}
