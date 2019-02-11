package learn.bj6e.ch11io;

import java.io.*;
import java.util.Scanner;

public class PopulationDensity {
    public static void main(String[] args) {
        String areaFile = "txt/world-area.txt";
        String popFile = "txt/world-pop.txt";
        String outFile = "txt/world-density.txt";

        try (Scanner areaIn = new Scanner(new File(areaFile));
                 Scanner popIn = new Scanner(new File(popFile));
                 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            var parser = new CountryValueParser();
            while (areaIn.hasNextLine() && popIn.hasNextLine()) {
                CountryValue area = parser.parse(areaIn);
                CountryValue population = parser.parse(popIn);
                if (!area.equalsByCountry(population)) {
                    throw new IllegalStateException("Different countries for " + area.getCountry());
                }
                double density = 0;
                if (area.getValue() != 0) {
                    density = (double) population.getValue() / area.getValue();
                }
                out.printf("%-40s%8.2f%n", area.getCountry(), density);
            }
        } catch (IOException e) {
            System.out.println("I/O error: e");
        }
    }
}
