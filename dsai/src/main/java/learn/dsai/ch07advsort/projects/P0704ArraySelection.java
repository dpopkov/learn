package learn.dsai.ch07advsort.projects;

import learn.dsai.ch03sorting.ArrayLong;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Using partitioning to find a k-th largest or k-th smallest element.
 */
public class P0704ArraySelection extends ArrayLong {
    public P0704ArraySelection(int max) {
        super(max);
    }

    @Override
    public void sort() {
        throw new NotImplementedException();
    }

    public long findNthLargest(int n) {
        return findNth(nElems - n);
    }

    public long findNthSmallest(int n) {
        return findNth(n - 1);
    }

    @SuppressWarnings("Duplicates")
    private long findNth(int index) {
        int right = nElems - 1;
        int pPrev = 0;
        int p = partitionIt(0, right);
        while (p != index) {
            if (p < index) {
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
        return a[p];
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
