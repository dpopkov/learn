package learn.ijpds.ch18recursion.exercises;

import learn.csia.utils.CliAppArgs;

public class E1802FibonacciIteration {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Index of Fibonacci number");
        int n = cli.nextInt();
        int f = fib(n);
        System.out.println("fib = " + f);
    }

    private static int fib(int n) {
        int prev = 0;
        int curr = 1;
        if (n == 0) {
            return prev;
        }
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
