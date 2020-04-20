package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0732Partitioning {
    /**
     * Partitions the list using the first element.
     * After the partition, the elements in the list are rearranged so all the elements
     * before the pivot are less than or equal to the pivot,
     * and the elements after the pivot are greater than the pivot.
     * @param list non-sorted array of integer values
     * @return index where the pivot is located in the new list
     */
    public static int partition(int[] list) {
        int pivot = list[0];
        int left = 1;
        int right = list.length - 1;
        while (left < right) {
            if (list[left] <= pivot) {
                left++;
            }
            if (list[right] >= pivot) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, 0, right);
        return right;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.inputIntArray("Enter list: ");
        int idx = partition(a);
        System.out.println("Pivot at index = " + idx);
        System.out.println(Arrays.toString(a));
    }
}
