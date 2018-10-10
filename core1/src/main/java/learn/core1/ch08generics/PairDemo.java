/* 8.1 */
package learn.core1.ch08generics;

public class PairDemo {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    private static class ArrayAlg {
        /**
         * Gets the minimum and maximum of an array of strings.
         * @param a array of strings
         * @return a pair with the min and max value, or null if a is null or empty
         */
        public static Pair<String> minMax(String[] a) {
            if (a == null || a.length == 0) {
                return null;
            }
            String min = a[0];
            String max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (min.compareTo(a[i]) > 0) {
                    min = a[i];
                }
                if (max.compareTo(a[i]) < 0) {
                    max = a[i];
                }
            }
            return new Pair<>(min, max);
        }
    }
}
