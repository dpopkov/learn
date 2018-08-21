package learn.csia.ch0102;

/**
 Arithmetic for integers is built into Java. Most of this code is devoted to the task of getting the
 values in and out; the actual arithmetic is in the simple statements in the middle of the program
 that assign values to p, q, and r.
 */
public class IntOps {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Needs 2 command line arguments (2 numbers)");
            System.exit(0);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int p = a * b;
        int q = a / b;
        int r = a % b;
        System.out.println(a + " * " + b + " = " + p);
        System.out.println(a + " / " + b + " = " + q);
        System.out.println(a + " % " + b + " = " + r);
        System.out.println(a + " = " + q + " * " + b + " + " + r);
    }
}
