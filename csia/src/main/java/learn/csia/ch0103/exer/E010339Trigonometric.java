package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

public class E010339Trigonometric {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter x");
        double x = in.nextDouble();
        double sineValue = sine(x);
        System.out.println(sineValue);
        System.out.println(Math.sin(x));
        double cosineValue = cosine(x);
        System.out.println(cosineValue);
        System.out.println(Math.cos(x));
    }

    private static double cosine(double x) {
        double sum = 0.0;
        double term = 1;
        boolean plus = true;
        for (int i = 1; term > 0; i += 2) {
            sum = plus ? sum + term : sum - term;
            term = term * x * x / i / (i + 1);
            plus = !plus;
        }
        return sum;
    }

    private static double sine(double x) {
        double sum = 0.0;
        double term = x;
        boolean plus = true;
        for (int i = 1; term > 0; i++) {
            sum = plus ? sum + term : sum - term;
            i++;
            term = term * x * x / i / (i + 1);
            plus = !plus;
        }
        return sum;
    }
}
