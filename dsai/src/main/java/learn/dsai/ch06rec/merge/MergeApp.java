package learn.dsai.ch06rec.merge;

import java.util.Arrays;

public class MergeApp {
    public static void main(String[] args) {
        int[] a = {23, 47, 81, 95};
        int[] b = {7, 14, 39, 55, 62, 74};
        int[] c = merge(a, 0, b, 0);
        System.out.println(Arrays.toString(c));
    }

    /**
     * Merges two sorted arrays into a third sorted array
     * @param a first sorted array
     * @param aLen length of the first array
     * @param b second sorted array
     * @param bLen length of the second array
     * @return sorted arrays containing all elements of input arrays
     */
    public static int[] merge(int[] a, int aLen, int[] b, int bLen) {
        int size = aLen + bLen;
        int[] rst = new int[size];
        int ia = 0, ib = 0, i = 0;
        while (ia < aLen && ib < bLen) {
            if (a[ia] < b[ib]) {
                rst[i++] = a[ia++];
            } else {
                rst[i++] = b[ib++];
            }
        }
        while (ia < aLen) {
            rst[i++] = a[ia++];
        }
        while (ib < bLen) {
            rst[i++] = b[ib++];
        }
        return rst;
    }
}
