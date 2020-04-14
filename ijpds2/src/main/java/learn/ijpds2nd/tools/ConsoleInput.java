package learn.ijpds2nd.tools;

import java.util.Scanner;

/**
 * Contains methods for input using standard system console and {@link Scanner}.
 */
public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public int[] inputSizeAndArray() {
        int n = getInt("Enter number of values: ");
        return getIntArray(n);
    }

    public int getInt(String prompt) {
        prompt = ensureColon(prompt);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public int[] getIntArray(int size) {
        int[] a = new int[size];
        System.out.printf("Enter %d integer values: ", size);
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    private String ensureColon(String prompt) {
        if (!prompt.endsWith(": ")) {
            prompt = prompt + ": ";
        }
        return prompt;
    }
}
