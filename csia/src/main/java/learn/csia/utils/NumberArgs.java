package learn.csia.utils;

import java.util.Scanner;

/**
 * This class combines input from command line arguments or numbers entered in standard input.
 * It will use input from one of them, but not both.
 */
public class NumberArgs {
    private boolean cmdArgs = false;
    private int currentIdx = 0;
    private String[] args;
    private Scanner in;
    private String[] prompts;

    /**
     * Creates input object using specified command line arguments.
     * @param args array of command line arguments (if null then standard input will be used)
     */
    public NumberArgs(String[] args) {
        this(args, null);
    }

    /**
     * Creates input object using specified command line arguments.
     * @param args array of command line arguments (if null then standard input will be used)
     * @param prompts array of prompt strings (will be used if values are received from standard input)
     */
    public NumberArgs(String[] args, String... prompts) {
        if (args.length > 0) {
            cmdArgs = true;
            this.args = args;
        } else {
            cmdArgs = false;
            in = new Scanner(System.in);
            this.prompts = prompts;
        }
    }

    public int nextInt() {
        if (cmdArgs) {
            checkCurrentIdx();
            return Integer.parseInt(getCmdArgument());
        } else {
            printPrompt();
            return in.nextInt();
        }
    }

    public double nextDouble() {
        if (cmdArgs) {
            checkCurrentIdx();
            return Double.parseDouble(getCmdArgument());
        } else {
            printPrompt();
            return in.nextDouble();
        }
    }

    public long nextLong() {
        if (cmdArgs) {
            checkCurrentIdx();
            return Long.parseLong(getCmdArgument());
        } else {
            printPrompt();
            return in.nextLong();
        }
    }

    private String getCmdArgument() {
        return args[currentIdx++];
    }

    private void checkCurrentIdx() {
        if (currentIdx == args.length) {
            throw new IllegalStateException("No more parameters");
        }
    }

    private void printPrompt() {
        if (prompts != null) {
            System.out.printf("%s: ", prompts[currentIdx++]);
        } else {
            System.out.print("> ");
        }
    }
}
