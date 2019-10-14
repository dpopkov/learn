package learn.dsajg6e.ch09pq2.exer;

public class C0944SelectionSort {
    public void sort(long[] values) {
        long temp;
        int n = values.length - 1;
        for (int i = 0; i < n; i++) {
            int j = indexOfMin(values, i);
            temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }

    private int indexOfMin(long[] values, int from) {
        int idx = from;
        long minimum = values[idx];
        for (int i = from + 1; i < values.length; i++) {
            if (values[i] < minimum) {
                minimum = values[i];
                idx = i;
            }
        }
        return idx;
    }
}
