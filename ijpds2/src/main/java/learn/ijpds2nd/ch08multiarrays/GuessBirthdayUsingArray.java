package learn.ijpds2nd.ch08multiarrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* Listing 8.6 */
public class GuessBirthdayUsingArray {
    public static void main(String[] args) {
        int day = 0;
        int answer;

        int[][][] dates = {
                {{1, 3, 5, 7}, {9, 11, 13, 15}, {17, 19, 21, 23}, {25, 27, 29, 31}},
                {{2, 3, 6, 7}, {10, 11, 14, 15}, {18, 19, 22, 23}, {26, 27, 30, 31}},
                {{4, 5, 6, 7}, {12, 13, 14, 15}, {20, 21, 22, 23}, {28, 29, 30, 31}},
                {{8, 9, 10, 11}, {12, 13, 14, 15}, {24, 25, 26, 27}, {28, 29, 30, 31}},
                {{16, 17, 18, 19}, {20, 21, 22, 23}, {24, 26, 26, 27}, {28, 29, 30, 31}}
        };
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Is your birthday in Set " + (i + 1) + "?");
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.printf("%4d", dates[i][j][k]);
                }
                System.out.println();
            }
            System.out.print("\nEnter 0 for No or 1 for Yes: ");
            answer = in.nextInt();
            if (answer == 1) {
                day += dates[i][0][0];
            }
        }
        System.out.println("Your birthday is " + day);
    }

    @SuppressWarnings("unused")
    private static void prepareData(String... sets) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String set : sets) {
            sb.append(System.lineSeparator());
            sb.append("{");
            String[] tokens = set.split("\n");
            for (String token : tokens) {
                sb.append("{");
                String[] numbers = token.split(" ");
                for (String number : numbers) {
                    sb.append(number);
                    sb.append(',');
                }
                removeTrailingComma(sb);
                sb.append("},");
            }
            removeTrailingComma(sb);
            sb.append("},");
        }
        removeTrailingComma(sb);
        sb.append("}");
        Path path = Paths.get("txt/output.txt");
        try {
            Files.writeString(path, sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeTrailingComma(StringBuilder sb) {
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setLength(sb.length() - 1);
        }
    }
}
