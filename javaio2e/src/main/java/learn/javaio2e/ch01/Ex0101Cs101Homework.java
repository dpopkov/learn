package learn.javaio2e.ch01;

import java.io.Console;

public class Ex0101Cs101Homework {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            String input = console.readLine("Please enter a number between 1 and 10: ");
            int max = Integer.parseInt(input);
            for (int i = 1; i < max; i++) {
                console.printf("%d%n", i * i);
            }
        } else {
            System.out.println("No console device is available for this virtual machine");
        }
    }
}
