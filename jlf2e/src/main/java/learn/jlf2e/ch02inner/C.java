/* Question 6. */
package learn.jlf2e.ch02inner;

public class C extends A.B {
    public C(A a) {
        a.super();  // will be --> super(a)
        System.out.println("C is created");
    }

    public static void main(String[] args) {
        new C(new A());
    }
}
