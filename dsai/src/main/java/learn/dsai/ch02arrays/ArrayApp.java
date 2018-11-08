package learn.dsai.ch02arrays;

import static learn.dsai.tools.ArrayTools.*;

/* Procedural style. */
public class ArrayApp {
    @SuppressWarnings("ManualArrayCopy")
    public static void main(String[] args) {
        long[] arr = new long[10];
        int nElems;
        int j;
        long searchKey;

        nElems = insert(arr, 77, 99, 44, 55, 22, 88, 11, 0, 66, 33);
        println(arr, nElems);

        searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey) {
                break;
            }
        }
        for(int k = j; k < nElems - 1; k++) {
            arr[k] = arr[k + 1];
        }
        nElems--;
        println(arr, nElems);
    }
}
