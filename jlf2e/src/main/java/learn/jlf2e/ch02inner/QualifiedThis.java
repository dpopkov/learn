/* 2-18. Use of the keyword this qualified with the class name. */
package learn.jlf2e.ch02inner;

public class QualifiedThis {
    private final int value = 828;

    private void printValue() {
        System.out.println("value = " + value);
        System.out.println("this.value = " + this.value);
        System.out.println("QualifiedThis.this.value = " + QualifiedThis.this.value);
    }

    private void printHiddenValue() {
        int value = 131;
        System.out.println("value = " + value);
        System.out.println("this.value = " + this.value);
        System.out.println("QualifiedThis.this.value = " + QualifiedThis.this.value);
    }

    public static void main(String[] args) {
        QualifiedThis qt = new QualifiedThis();
        qt.printValue();
        qt.printHiddenValue();
    }
}
