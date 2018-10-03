/*
1.3.43
Median of 5.
The value such that two of the other integers are smaller and two are larger.
 */
package learn.csia.ch0103.exer;

public class E010343MedianOf5 {
    public int median5(int... v) {
        if (v.length != 5) {
            throw new IllegalArgumentException("There must be 5 parameters");
        }
        for (int i = 0; i < v.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[max] < v[j]) {
                    max = j;
                }
            }
            if (max != i) {
                swap(v, i, max);
            }
        }
        return v[2];
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        E010343MedianOf5 m = new E010343MedianOf5();
        System.out.println(m.median5(3, 5, 7, 9, 10));
    }
}
