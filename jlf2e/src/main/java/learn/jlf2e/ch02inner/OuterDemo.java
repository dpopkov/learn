/* 2-15. Testing an inner class that accesses the instance members of its enclosing class. */
package learn.jlf2e.ch02inner;

public class OuterDemo {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner in = out.new Inner();

        out.printValue();
        in.printValue();
        out.setValue(828);
        out.printValue();
        in.printValue();
    }
}
