package learn.dsajg6e.tools;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    private Input() {}

    public Scanner getScanner() {
        return scanner;
    }

    private static final Input instance = new Input();

    public static long nextLong(String prompt) {
        System.out.print(prompt);
        return instance.getScanner().nextLong();
    }

    public static int nextInt(String prompt) {
        System.out.print(prompt);
        return instance.getScanner().nextInt();
    }

    public static String next(String prompt) {
        System.out.print(prompt);
        return instance.getScanner().next();
    }

    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return instance.getScanner().nextLine();
    }

    public static int optionalIntArgument(String[] args, int argIdx, String prompt) {
        int argValue;
        if (args.length > argIdx) {
            argValue = Integer.parseInt(args[argIdx]);
        } else {
            argValue = Input.nextInt(prompt);
        }
        return argValue;
    }
}
