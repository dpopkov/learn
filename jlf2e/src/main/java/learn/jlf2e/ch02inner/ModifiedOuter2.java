/* 2-20. Using the keyword this qualified with the class name. */
package learn.jlf2e.ch02inner;

public class ModifiedOuter2 {
    private int value = 1116;

    public class Inner {
        private final int value = 1720;

        public void printValue() {
            System.out.println("\nInner - printValue()...");
            System.out.println("Inner: value = " + value);
            System.out.println("Outer: value = " + ModifiedOuter2.this.value);
        }
    }

    public void printValue() {
        System.out.println("\nOuter - printValue()...");
        System.out.println("Outer: value = " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ModifiedOuter2 out = new ModifiedOuter2();
        ModifiedOuter2.Inner in = out.new Inner();

        out.printValue();
        in.printValue();
        out.setValue(828);
        out.printValue();
        in.printValue();
    }
}
