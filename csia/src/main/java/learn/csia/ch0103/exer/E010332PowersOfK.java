package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;
import learn.csia.utils.NumberUtils;

/**
 * 1.3.32 Write a program that takes an integer k and prints all the positive powers of k
 * in the Java long type.
 */
public class E010332PowersOfK {
    public static void main(String[] args) throws ReflectiveOperationException {
        CliAppArgs in = new CliAppArgs(args,
                "Enter integer number", "Enter host type (Byte, Short, Integer, or Long)");
        int k = in.nextInt();
        String typeName = in.nextString();
        long maxValue = NumberUtils.getMaxValueFor(typeName);
        long limit = maxValue / k;
        for (long p = k; p <= limit; ) {
            p = p * k;
            System.out.println(p);
        }
    }
}
