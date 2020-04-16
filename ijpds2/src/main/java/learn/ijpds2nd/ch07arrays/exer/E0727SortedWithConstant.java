package learn.ijpds2nd.ch07arrays.exer;

public class E0727SortedWithConstant {
    /** Returns true if the elements of the array are arranged in an ascending order
     * with a constant difference between them. */
    public boolean sortedWithConstant(int[] a) {
        int diff = a[1] - a[0];
        if (diff < 0) {
            return false;
        }
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
