package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

public class E010338Exponential {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter double value");
        double x = in.nextDouble();
        double ex = taylorSeries(x);
        System.out.println(ex);
        System.out.println(Math.exp(x));
    }

    private static double taylorSeries(double x) {
        double sum = 0.0;
        double term = 1.0;
        for (int i = 1; sum < sum + term; i++) {
            sum += term;
            term = term * x / i;
            System.out.println(i);
        }
        return sum;
    }
}
