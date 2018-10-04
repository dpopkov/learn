/*
13.19
Convert decimals to fractions.
 */
package learn.ijpds.ch13abstract.exercises;

import learn.csia.utils.CliAppArgs;

public class E1319ToFractions {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter decimal number");
        String s = cli.nextString();
        int pos = s.indexOf(".");
        String i = s.substring(0, pos);
        String f = s.substring(pos + 1);
        String n = i + f;
        String d = Integer.toString((int)Math.pow(10, n.length() - 1));
        System.out.println("n = " + n);
        System.out.println("d = " + d);
        E1315Rational rational = new E1315Rational(n, d);
        System.out.println(rational);
    }
}
