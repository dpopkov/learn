package learn.dsajg6e.ch05recursion.exer;

import learn.dsajg6e.ch05recursion.PuzzlePermutations;
import learn.dsajg6e.tools.ArrayTools;

import java.util.*;

/*
Write a program for solving summation puzzles by enumerating and testing all possible configurations.
Examples of puzzles to solve:
pot + pan = bib   -->  034 + 087 = 121
dog + cat = pig   -->  123 + 460 = 583
boy + girl = baby -->  345 + 2790 = 3135
 */
public class P0528SummationPuzzle {
    static String solve(String puzzle) {
        String[] tokens = puzzle.split("\\s*([+=])\\s*");
        char[] chars = extractCharSet(tokens);
        char[] allDigits = "0123456789".toCharArray();
        List<String> digitUniverses = new ArrayList<>();
        PuzzlePermutations.solve(chars.length, "", allDigits, digitUniverses);
        for (String universe : digitUniverses) {
            Map<Character, Integer> map = createMap(chars, universe);
            if (mapIsSolving(map, tokens)) {
                return mapToExpression(tokens, map);
            }
        }
        return null;
    }

    private static Map<Character, Integer> createMap(char[] chars, String digits) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], digits.charAt(i) - '0');
        }
        return map;
    }

    private static String mapToExpression(String[] tokens, Map<Character, Integer> map) {
        return formatOperand(tokens[0], map) + " + " +
                formatOperand(tokens[1], map) + " = " +
                formatOperand(tokens[2], map);
    }

    private static String formatOperand(String token, Map<Character, Integer> map) {
        int op = tokenToNumber(token, map);
        StringBuilder rst = new StringBuilder(Integer.toString(op));
        while (rst.length() < token.length()) {
            rst.insert(0, "0");
        }
        return rst.toString();
    }

    private static boolean mapIsSolving(Map<Character, Integer> map, String[] tokens) {
        int op1 = tokenToNumber(tokens[0], map);
        int op2 = tokenToNumber(tokens[1], map);
        int sum = tokenToNumber(tokens[2], map);
        return op1 + op2 == sum;
    }

    private static int tokenToNumber(String token, Map<Character, Integer> map) {
        int idx = 0;
        int rst = 0;
        while (idx < token.length()) {
            rst *= 10;
            rst += map.get(token.charAt(idx));
            idx++;
        }
        return rst;
    }

    private static char[] extractCharSet(String[] tokens) {
        int maxLength = tokens[0].length() + tokens[1].length() + tokens[2].length();
        char[] buffer = new char[maxLength];
        int charCount = 0;
        for (String s : tokens) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int foundIdx = ArrayTools.find(buffer, charCount, c);
                if (foundIdx == -1) {
                    buffer[charCount++] = c;
                }
            }
        }
        return Arrays.copyOf(buffer, charCount);
    }

    public static void main(String[] args) {
        String[] pa = {
                "pot + pan = bib",
                "dog + cat = pig",
                "boy + girl = baby"
        };
        for (String p : pa) {
            System.out.println("p = " + p);
            String r = solve(p);
            System.out.println("r = " + r);
        }
    }
}
