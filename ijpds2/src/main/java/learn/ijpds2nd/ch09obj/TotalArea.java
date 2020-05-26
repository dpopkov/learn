package learn.ijpds2nd.ch09obj;

/* Listing 9.11 */
public class TotalArea {
    public static void main(String[] args) {
        Circle[] circles = createCircleArray();
        printCircleArray(circles);
    }

    private static Circle[] createCircleArray() {
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(Math.random() * 100);
        }
        return circles;
    }

    private static void printCircleArray(Circle[] circles) {
        System.out.printf("%30s%15s%n", "Radius", "Area");
        for (Circle circle : circles) {
            System.out.printf("%30.4f%15.4f%n", circle.getRadius(), circle.area());
        }
        System.out.println("---------------------------------------------");
        System.out.printf("%30s%15.4f%n", "The total area of circles is", sum(circles));
    }

    private static double sum(Circle[] circles) {
        double sum = 0;
        for (Circle c : circles) {
            sum += c.area();
        }
        return sum;
    }
}
