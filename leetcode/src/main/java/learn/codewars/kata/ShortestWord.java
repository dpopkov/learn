package learn.codewars.kata;

import java.util.Arrays;

public class ShortestWord {
    public static int findShort(String s) {
        return Arrays.stream(s.split("\\s+"))
                .mapToInt(String::length)
                .min().getAsInt();
    }
}
