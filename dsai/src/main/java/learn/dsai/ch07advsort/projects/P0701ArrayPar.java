/* 7.2 */
package learn.dsai.ch07advsort.projects;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates partitioning an array.
 */
public class P0701ArrayPar extends ArrayLong {
    public P0701ArrayPar(int max) {
        super(max);
    }

    @Override
    public void sort() {
        throw new AssertionError("Not implemented method");
    }

    @SuppressWarnings("Duplicates")
    public int partitionIt(int left, int right) {
        int leftPtr = left - 1;
        int rightPtr = right;
        long pivot = a[right];
        while (true) {
            while (leftPtr < right) {
                leftPtr++;
                if (a[leftPtr] >= pivot) {
                    break;
                }
            }
            // post-condition: leftPtr == right OR a[leftPtr] >= pivot
            while (rightPtr > left) {
                rightPtr--;
                if (a[rightPtr] <= pivot) {
                    break;
                }
            }
            // post-condition: rightPtr == left OR a[rightPtr] <= pivot
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }
}
