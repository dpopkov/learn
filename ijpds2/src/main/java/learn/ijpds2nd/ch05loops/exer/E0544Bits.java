package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0544Bits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a byte integer: ");
        byte b = in.nextByte();
        int digit = 0b10000000;
        for (int i = 0; i < 8; i++) {
            boolean hasBit = (b & digit) != 0;
            System.out.print(hasBit ? "1" : "0");
            digit >>= 1;
        }
        System.out.println();
    }
}
