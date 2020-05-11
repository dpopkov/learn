package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

/**
 * Given a set of cities, the central city is the city that has the shortest
 * total distance to all other cities.
 */
public class E0821CentralCity {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int n = in.getInt("Enter the number of cities: ");
        double[] coordinates = in.getDoubleArray(n, "Enter the coordinates of the cities: ");
        double[] xy = findCentralCity(coordinates);
        System.out.printf("Coordinates of city in the center: %.2f, %.2f%n", xy[0], xy[1]);
    }

    static double[] findCentralCity(double[] coordinates) {
        double minTotalDistance = Double.MAX_VALUE;
        int numCities = coordinates.length / 2;
        double centerX = Double.MAX_VALUE;
        double centerY = Double.MAX_VALUE;
        for (int i = 0; i < coordinates.length; i += 2) {
            double x = coordinates[i];
            double y = coordinates[i + 1];
            double totalDistance = 0;
            for (int j = 0, k = i + 2; j < numCities - 1; j++, k += 2) {
                if (k >= coordinates.length) {
                    k = 0;
                }
                double dist = distance(x, y, coordinates[k], coordinates[k + 1]);
                totalDistance += dist;
            }
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
                centerX = x;
                centerY = y;
            }
        }
        return new double[]{centerX, centerY, minTotalDistance};
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
