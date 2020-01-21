package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0303SortThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a <= b) {
            if (b <= c) {
                print(a, b, c);
            } else {
                if (a < c) {
                    print(a, c, b);
                } else {
                    print(c, a, b);
                }
            }
        } else {    // a > b
            if (a <= c) {
                print(b, a, c);
            } else {    // a > c
                if (b <= c) {
                    print(b, c, a);
                } else {
                    print(c, b, a);
                }
            }
        }
    }

    private static void print(int x, int y, int z) {
        System.out.println(x + ", " + y + ", " + z);
    }
}
