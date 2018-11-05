package learn.ijpds.ch18recursion.exercises;

public class E1813Largest {
    public static void main(String[] args) {
        int[] a = {3, 2, 7, 1, 8, 9, 5, 4, 6};
        int r = largest(a);
        System.out.println("r = " + r);
    }

    public static int largest(int[] a) {
        return largest(a, 0);
    }

    private static int largest(int[] a, int from) {
        int rst = a[from];
        if (from < a.length - 1) {
            int r2 = largest(a, from + 1);
            rst = r2 > rst ? r2 : rst;
        }
        return rst;
    }
}
