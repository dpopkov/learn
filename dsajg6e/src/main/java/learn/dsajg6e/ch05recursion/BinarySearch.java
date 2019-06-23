package learn.dsajg6e.ch05recursion;

public class BinarySearch {
    static boolean search(int[] data, int target) {
        return search(data, target, 0, data.length - 1);
    }

    private static boolean search(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = low + (high - low) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                return search(data, target, low, mid - 1);
            } else {
                return search(data, target, mid + 1, high);
            }
        }
    }
}
