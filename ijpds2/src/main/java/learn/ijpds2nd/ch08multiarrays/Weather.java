package learn.ijpds2nd.ch08multiarrays;

import java.util.Locale;
import java.util.Scanner;

/* Listing 8.5 */
public class Weather {

    private static final int NUM_DAYS = 10;
    private static final int NUM_HOURS = 24;

    public static void main(String[] args) {
        double[][][] data = new double[NUM_DAYS][NUM_HOURS][2];
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        readData(data, scanner);
        double[][] averages = processData(data);
        for (int dayIdx = 0; dayIdx < averages.length; dayIdx++) {
            System.out.println("Day: " + (dayIdx + 1));
            System.out.printf("\taverage temperature is %.2f%n", averages[dayIdx][0]);
            System.out.printf("\taverage humidity is %.2f%n", averages[dayIdx][1]);
        }
    }

    private static double[][] processData(double[][][] data) {
        int numDays = data.length;
        double[][] averages = new double[numDays][2];
        for (int dayIdx = 0; dayIdx < numDays; dayIdx++) {
            double totalTemperature = 0;
            double totalHumidity = 0;
            int numHours = data[dayIdx].length;
            for (int hourIdx = 0; hourIdx < numHours; hourIdx++) {
                totalTemperature += data[dayIdx][hourIdx][0];
                totalHumidity += data[dayIdx][hourIdx][1];
            }
            double avgTemperature = totalTemperature / numHours;
            double avgHumidity = totalHumidity / numHours;
            averages[dayIdx][0] = avgTemperature;
            averages[dayIdx][1] = avgHumidity;
        }
        return averages;
    }

    private static void readData(double[][][] data, Scanner in) {
        while (in.hasNextLine()) {
            int day = in.nextInt();
            int hour = in.nextInt();
            double temperature = in.nextDouble();
            double humidity = in.nextDouble();
            data[day - 1][hour - 1][0] = temperature;
            data[day - 1][hour - 1][1] = humidity;
        }
    }
}
