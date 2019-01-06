/* 7.2 */
package learn.dsai.ch07advsort.projects;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Using partitioning to find a median of an array.
 */
public class P0703ArrayMedian extends ArrayLong {
    public P0703ArrayMedian(int max) {
        super(max);
    }

    @Override
    public void sort() {
        throw new AssertionError("Not implemented method");
    }

    public int median() {
        int m = nElems / 2;
        int right = nElems - 1;
        int pPrev = 0;
        int p = partitionIt(0, right);
        while (p != m) {
            if (p < m) {
                if (p == pPrev) {
                    p++;
                }
                p = partitionIt(p, right);
            } else {
                if (p == pPrev) {
                    p--;
                }
                p = partitionIt(0, p);
            }
            pPrev = p;
        }
        return p;
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
