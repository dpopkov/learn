package learn.jlf2e.ch02inner;

/**
 * Used for class C (Question 6).
 */
public class A {
    public class B {
        public B() {
            System.out.println("B is created");
        }
    }

    public A() {
        System.out.println("A is created");
    }
}
