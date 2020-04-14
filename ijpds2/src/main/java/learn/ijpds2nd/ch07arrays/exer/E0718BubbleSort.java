package learn.ijpds2nd.ch07arrays.exer;

public class E0718BubbleSort {
    public void bubbleSort(int[] a) {
        int last = a.length - 1;
        for (int i = 0; i < last; i++) {
            for (int j = 0; j < last - i; j++) {
                int next = j + 1;
                if (a[j] > a[next]) {
                    int tmp = a[j];
                    a[j] = a[next];
                    a[next] = tmp;
                }
            }
        }
    }
}
