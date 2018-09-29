/* 2-17. Testing an inner class that accesses the instance members of its enclosing class. */
package learn.jlf2e.ch02inner;

public class Outer2Demo {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        Outer2.Inner2 in = out.new Inner2();

        out.printValue();
        in.printValue();
        out.setValue(828);
        out.printValue();
        in.printValue();
    }
}
