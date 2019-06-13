package learn.dsajg6e.ch03fund.exer;

public class C0317FindRepeated {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 2};
        int idx = findRepeated(a);
        System.out.println("idx = " + idx);
    }

    /** Finds index of repeated element. */
    static int findRepeated(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    return j;
                }
            }
        }
        return -1;
    }
}
