package learn.core1.ch05;

import java.util.Scanner;

public class EnumUsage {
    @SuppressWarnings("unused")
    private enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

        private final String abbreviation;

        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        String getAbbreviation() { return abbreviation; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Size size = null;
        boolean ok;
        do {
            System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
            String input = in.next().toUpperCase();
            try {
                size = Enum.valueOf(Size.class, input);
                ok = true;
            } catch (java.lang.IllegalArgumentException e) {
                ok = false;
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        } while (!ok);
        System.out.println("size = " + size);
        System.out.println("abbreviation = " + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job -- you paid attention to the _.");
        }
    }
}
