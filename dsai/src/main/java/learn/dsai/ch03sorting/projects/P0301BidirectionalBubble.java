package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Array wrapper implementing bidirectional bubble sort.
 */
public class P0301BidirectionalBubble extends ArrayLong {
    public P0301BidirectionalBubble(int max) {
        super(max);
    }

    @Override
    public void sort() {
        bidirectionalBubbleSort();
    }

    public void bidirectionalBubbleSort() {
        int left = 0;
        int right = nElems - 1;
        while (left < right) {
            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(j - 1, j);
                }
            }
            left++;
        }
    }
}
