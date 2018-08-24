package learn.csia.ch0103;

import learn.csia.utils.NumberArgs;

public class Sqrt {
    public static void main(String[] args) {
        NumberArgs in = new NumberArgs(args, new String[] {"Enter argument"});
        double c = in.nextDouble();
        double EPSILON = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > EPSILON * t) {
            t = (c / t + t) / 2.0;
        }
        System.out.println(t);
    }
}
