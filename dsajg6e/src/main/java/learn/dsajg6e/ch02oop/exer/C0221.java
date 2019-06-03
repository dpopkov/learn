package learn.dsajg6e.ch02oop.exer;

public class C0221 {
    public static void main(String[] args) {
        C c = new C();
        c.printA();
        c.printB();
        c.printC();
        c.changeX();
        c.printA();
        c.printB();
        c.printC();
    }

    private static class A {
        public int x = 0;

        public void printA() {
            System.out.println("A{x=" + x + "}");
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    private static class B extends A {
        public final int x = 1;

        public void printB() {
            System.out.println("B{x=" + x + "}");
        }
    }

    private static class C extends B {
        public final int x = 2;

        void changeX() {
            super.setX(42);
        }

        public void printC() {
            System.out.println("C{x=" + x + "}");
        }
    }
}
