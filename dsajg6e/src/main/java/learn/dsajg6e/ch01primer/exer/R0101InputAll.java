package learn.dsajg6e.ch01primer.exer;

import java.util.Scanner;

public class R0101InputAll {
    public static void main(String[] args) {
        inputAllBaseTypes();
    }

    static void inputAllBaseTypes() {
        Scanner in = new Scanner(System.in);
        System.out.print("Byte value: ");
        byte b = in.nextByte();
        System.out.println("b = " + b);
        System.out.print("Short value: ");
        short s = in.nextShort();
        System.out.println("s = " + s);
        System.out.print("Int value: ");
        int i = in.nextInt();
        System.out.println("i = " + i);
        System.out.print("Long value: ");
        long l = in.nextLong();
        System.out.println("l = " + l);
        System.out.print("Float value: ");
        float f = in.nextFloat();
        System.out.println("f = " + f);
        System.out.print("Double value: ");
        double d = in.nextDouble();
        System.out.println("d = " + d);
        System.out.print("Boolean value: ");
        boolean bn = in.nextBoolean();
        System.out.println("bn = " + bn);
    }
}
