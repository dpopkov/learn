package learn.ijpds2nd.ch07arrays;

/* Listing 7.3 */
public class TestPassArray {
    public static void main(String[] args) {
        int[] a = {1, 2};

        System.out.println("Before invoking swap");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
        swap(a[0], a[1]);
        System.out.println("After invoking swap");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
        System.out.println("Before invoking swapFirstTwoInArray");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
        swapFirstTwoInArray(a);
        System.out.println("After invoking swapFirstTwoInArray");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
    }

    private static void swapFirstTwoInArray(int[] a) {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
    }

    @SuppressWarnings("UnusedAssignment")
    private static void swap(int n1, int n2) {
        int tmp = n1;
        n1 = n2;
        n2 = tmp;
    }
}
