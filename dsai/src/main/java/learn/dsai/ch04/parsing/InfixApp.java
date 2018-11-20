/* 4.7 */
package learn.dsai.ch04.parsing;

import java.util.Scanner;

public class InfixApp {
    public static void main(String[] args) {
        boolean log = false;
        if (args.length == 1 && "--log".equals(args[0])) {
            log = true;
        }
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String input, output;
        do {
            System.out.print("Enter infix: ");
            input = in.nextLine();
            if (input.isEmpty()) {
                done = true;
            } else {
                InToPost translator = new InToPost(input, log);
                output = translator.translate();
                System.out.println("Postfix is " + output);
            }
        } while (!done);
    }
}
