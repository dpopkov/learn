package learn.ijpds2nd.ch07arrays.exer;

public class E0734SortCharacters {
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        sort(chars);
        return String.valueOf(chars);
    }

    private static void sort(char[] a) {
        int last = a.length - 1;
        for (int i = 0; i < last; i++) {
            for (int j = 0; j < last - i; j++) {
                int k = j + 1;
                if (a[j] > a[k]) {
                    char tmp = a[j];
                    a[j] = a[k];
                    a[k] = tmp;
                }
            }
        }
    }
}
