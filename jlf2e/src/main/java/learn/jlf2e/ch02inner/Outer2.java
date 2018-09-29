package learn.jlf2e.ch02inner;

public class Outer2 {
    private int value = 1116;

    public class Inner2 {
        private final int value = 1720;

        public void printValue() {
            System.out.println("Inner2: value = " + value);
        }
    }

    public void printValue() {
        System.out.println("Outer2: value = " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
