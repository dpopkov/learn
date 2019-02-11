package learn.bj6e.ch11io;

import java.util.Scanner;

/**
 * Parses one line using supplied scanner object.
 * Each line should contain one or more words and end with an integer number.
 */
public class CountryValueParser {
    private final StringBuilder buffer = new StringBuilder();

    public CountryValue parse(Scanner in) {
        String country = getCountry(in);
        int value = getNumber(in);
        return new CountryValue(country, value);
    }

    private String getCountry(Scanner in) {
        buffer.setLength(0);
        while (in.hasNext() && !in.hasNextInt()) {
            buffer.append(in.next());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }

    private int getNumber(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        return n;
    }
}
