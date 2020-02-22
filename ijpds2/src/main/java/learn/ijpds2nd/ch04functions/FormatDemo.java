package learn.ijpds2nd.ch04functions;

/** Listing 4.6 */
public class FormatDemo {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%n", "Degrees", "Radians", "Sine", "Cosine", "Tangent");
        printFunctionValues(30);
        printFunctionValues(60);
    }

    private static void printFunctionValues(int degrees) {
        double radians = Math.toRadians(degrees);
        System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f%n",
                degrees, radians, Math.sin(radians), Math.cos(radians), Math.tan(radians));
    }
}
