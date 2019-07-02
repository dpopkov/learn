package learn.dsajg6e.ch05recursion.exer;

/*
Provide a non-recursive implementation of the drawInterval method
for the EnglishRuler project.
 */
public class P0529DrawIntervalNonRecursive {
    private static final String NL = System.lineSeparator();

    static String drawInterval(int centralTick) {
        int n = (int) Math.pow(2, centralTick) - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int length = countConsecutiveOnes(i) + 1;
            sb.append("-".repeat(length));
            sb.append(NL);
        }
        return sb.toString();
    }

    private static int countConsecutiveOnes(int x) {
        int count = 0;
        while ((x & 1) == 1) {
            count++;
            x = x >> 1;
        }
        return count;
    }
}
