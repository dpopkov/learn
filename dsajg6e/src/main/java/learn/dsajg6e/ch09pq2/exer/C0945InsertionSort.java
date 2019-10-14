package learn.dsajg6e.ch09pq2.exer;

public class C0945InsertionSort {
    public void sort(long[] values) {
        for (int i = 1; i < values.length; i++) {
            long current = values[i];
            int j = i;
            while (j > 0 && values[j - 1] > current) {
                values[j] = values[j - 1];
                j--;
            }
            values[j] = current;
        }
    }
}
