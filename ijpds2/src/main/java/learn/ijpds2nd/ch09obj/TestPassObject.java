package learn.ijpds2nd.ch09obj;

/* Listing 9.10 */
public class TestPassObject {
    public static void main(String[] args) {
        Circle circle = new Circle(1.0);
        int n = 5;
        printAreas(circle, n);
        System.out.println("\n" + "Radius is " + circle.getRadius());
        System.out.println("n is " + n);
    }

    private static void printAreas(Circle circle, int times) {
        System.out.println("Radius\t\tArea");
        while (times >= 1) {
            System.out.println(circle.getRadius() + "\t\t" + circle.area());
            circle.setRadius(circle.getRadius() + 1);
            times--;
        }
    }
}
