package learn.dsajg6e.ch05recursion.exer;

public class R0502BinSearch {
    public static int search(int[] data, int target) {
        return search(data, target, 0, data.length - 1);
    }

    private static int search(int[] data, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (data[mid] == target) {
            return mid;
        } else if (data[mid] < target) {
            return search(data, target, mid + 1, high);
        } else {
            return search(data, target, low, high - 1);
        }
    }
}
