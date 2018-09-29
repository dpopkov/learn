/* 2-14. Accessing instance members of the enclosing class form an inner class. */
package learn.jlf2e.ch02inner;

public class Outer {
    private int value = 1116;

    public class Inner {
        public void printValue() {
            System.out.println("Inner: value = " + value);
        }
    }

    public void printValue() {
        System.out.println("Outer: value = " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
