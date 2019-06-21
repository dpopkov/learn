package learn.dsajg6e.ch04analysis;

import java.util.Scanner;

/*
  size       #1    #2      #3
-----------------------------
 50000      230     4       1
100000      903     5       1
200000     2470     5       2
400000     8951     7       3
800000    37574    14       3
 */
@SuppressWarnings({"SameParameterValue", "UnusedReturnValue", "ResultOfMethodCallIgnored"})
public class ExperimentsConcatenation {
    public static void main(String[] args) {
        int size;
        if (args.length == 1) {
            size = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter size: ");
            size = scanner.nextInt();
        }
        long start, end;
        start = System.currentTimeMillis();
        repeat1('*', size);
        end = System.currentTimeMillis();
        System.out.printf("#1: %d%n", (end - start));

        start = System.currentTimeMillis();
        repeat2('*', size);
        end = System.currentTimeMillis();
        System.out.printf("#2: %d%n", (end - start));

        start = System.currentTimeMillis();
        repeat3('*', size);
        end = System.currentTimeMillis();
        System.out.printf("#3: %d%n", (end - start));
    }

    /** Ues repeated concatenation to compose a string with n copies of character c. */
    @SuppressWarnings("StringConcatenationInLoop")
    private static String repeat1(char c, int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += c;
        }
        return answer;
    }

    @SuppressWarnings("StringRepeatCanBeUsed")
    private static String repeat2(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String repeat3(char c, int n) {
        return String.valueOf(c).repeat(Math.max(0, n));
    }
}
