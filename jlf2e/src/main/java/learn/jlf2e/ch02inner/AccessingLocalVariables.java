/* 2-22. Accessing local variables inside local classes. */
package learn.jlf2e.ch02inner;

public class AccessingLocalVariables {
    public static void main(String[] args) {
        int x = 100;
        final int y = 200;

        class LocalInner {
            private void print() {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }
        }
//        x = 101;
        LocalInner local = new LocalInner();
        local.print();
    }
}
