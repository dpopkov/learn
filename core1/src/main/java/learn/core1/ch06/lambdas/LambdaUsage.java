package learn.core1.ch06.lambdas;

import javax.swing.*;
import java.time.LocalTime;
import java.util.Arrays;

public class LambdaUsage {
    public static void main(String[] args) {
        useComparator();
        useActionListener();
    }

    private static void useActionListener() {
        Timer t = new Timer(1_000, event ->
                System.out.println("The time is " + LocalTime.now()));
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    private static void useComparator() {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        print("Initial order:", planets);
        Arrays.sort(planets);
        print("Sorted in dictionary order:", planets);
        //noinspection ComparatorCombinators
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        print("Sorted by length:", planets);
    }

    private static void print(String title, String[] planets) {
        System.out.println(title);
        System.out.println(Arrays.toString(planets));
    }
}
