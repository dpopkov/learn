package learn.ijpds2nd.ch07arrays.exer;

public class E0725SolveQuadratic {
    /**
     * Solves a quadratic equation
     * @param eqn coefficients of the equation
     * @param roots the specified array of size 2 will store calculated roots of the equation
     * @return number of roots
     */
    public static int solveQuadraticEquation(double[] eqn, double[] roots) {
        double a = eqn[0];
        double b = eqn[1];
        double c = eqn[2];
        double d = discriminant(b, a, c);
        if (d < 0) {
            return 0;
        } else if (d == 0.0) {
            roots[0] = -b / (2 * a);
            return 1;
        } else {
            double r1 = (-b + Math.pow(d, 0.5)) / (2 * a);
            double r2 = (-b - Math.pow(d, 0.5)) / (2 * a);
            roots[0] = r1;
            roots[1] = r2;
            return 2;
        }
    }

    private static double discriminant(double b, double a, double c) {
        return b * b - 4 * a * c;
    }
}
