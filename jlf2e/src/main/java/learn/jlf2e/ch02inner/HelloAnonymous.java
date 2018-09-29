/* 2-9. An anonymous class example. */
package learn.jlf2e.ch02inner;

public class HelloAnonymous {
    public static void main(String[] args) {
        new Object() {
            {
                System.out.println("Hello from an anonymous class.");
            }
        };
    }
}
