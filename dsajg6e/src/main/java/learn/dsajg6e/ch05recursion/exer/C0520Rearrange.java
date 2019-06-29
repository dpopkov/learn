package learn.dsajg6e.ch05recursion.exer;

/*
Write a short recursive Java method that rearranges an array of integer values so
that all the even values appear before all the odd values.
 */
public class C0520Rearrange {
    static void rearrange(int[] a) {
        if (a.length < 2) {
            return;
        }
        rearrange(a, 0);
    }

    private static void rearrange(int[] a, int from) {
        if (from == a.length) {
            return;
        }
        int i = from;
        while (i < a.length && a[i] % 2 == 0) {
            i++;
        }
        // Post condition: a[i] is odd OR i == a.length
        if (i == a.length) {
            return;
        }
        int odd = i;
        while (i < a.length && a[i] % 2 != 0) {
            i++;
        }
        // Post condition: a[i] is even OR i == a.length
        if (i == a.length) {
            return;
        }
        int even = i;
        swap(a, odd, even);
        rearrange(a, odd + 1);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
