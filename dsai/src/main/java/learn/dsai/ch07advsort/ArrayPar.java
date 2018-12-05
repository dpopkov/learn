/* 7.2 */
package learn.dsai.ch07advsort;

import learn.dsai.ch03sorting.ArrayLong;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Demonstrates partitioning an array.
 */
public class ArrayPar extends ArrayLong {
    public ArrayPar(int max) {
        super(max);
    }

    @Override
    public void sort() {
        throw new NotImplementedException();
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
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
        return leftPtr;
    }
}
