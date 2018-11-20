package learn.dsai.ch04.parsing;

import java.util.Scanner;

public class PostfixApp {
    public static void main(String[] args) {
        boolean log = false;
        if (args.length == 1 && "--log".equals(args[0])) {
            log = true;
        }
        Scanner in = new Scanner(System.in);
        ParsePost parser = new ParsePost(log);
        boolean done = false;
        do {
            System.out.print("Enter postfix: ");
            String input = in.nextLine();
            if (input.isEmpty()) {
                done = true;
            } else {
                long result = parser.parse(input);
                System.out.println("Evaluates to " + result);
            }
        } while (!done);
    }
}
