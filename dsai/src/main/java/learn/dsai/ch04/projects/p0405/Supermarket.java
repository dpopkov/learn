package learn.dsai.ch04.projects.p0405;

import java.util.Random;
import java.util.Scanner;

public class Supermarket {
    private static final Random random = new Random();

    private int count;
    private final CheckoutLine[] lines = new CheckoutLine[3];
    {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new CheckoutLine();
        }
    }

    public void addRandomTo(int lineIdx) {
        int groceries = 1 + random.nextInt(3);
        Customer customer = new Customer(++count, groceries);
        lines[lineIdx].add(customer);
        display();
    }

    public void tick() {
        for (CheckoutLine line : lines) {
            line.tick();
        }
        display();
    }

    public void display() {
        for (int i = 0; i < lines.length; i++) {
            CheckoutLine line = lines[i];
            System.out.printf("%d : %s%n", i, line);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Supermarket supermarket = new Supermarket();
        boolean running = true;
        System.out.println("Enter line index, empty string to tick, or 'x' to exit:");
        while (running) {
            System.out.print("line#: ");
            String input = in.nextLine();
            if ("x".equals(input)) {
                running = false;
            } else {
                if (input.isEmpty()) {
                    supermarket.tick();
                } else {
                    int lineIdx = Integer.parseInt(input);
                    supermarket.addRandomTo(lineIdx);
                }
            }
        }
    }
}
