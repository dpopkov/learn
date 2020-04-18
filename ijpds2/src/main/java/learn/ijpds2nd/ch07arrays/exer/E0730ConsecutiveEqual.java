package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

/*
Write the method that tests whether the array has four consecutive numbers
with the same value.
 */
public class E0730ConsecutiveEqual {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.inputIntArray("Enter integer values: ");
        boolean b = isConsecutiveFour(a);
        System.out.printf("The array %s consecutive four values.%n", b ? "has" : "has not");
    }

    private static boolean isConsecutiveFour(int[] a) {
        int count = 1;
        int p = a[0];
        for (int i = 1; i < a.length; i++) {
            if (p == a[i]) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                p = a[i];
                count = 1;
            }
        }
        return false;
    }
}
