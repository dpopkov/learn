package learn.ijpds2nd.ch08multiarrays;

import java.util.Arrays;

public class RandomShuffling {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};
        shuffle(a);
        System.out.println(Arrays.deepToString(a));
    }


    private static void shuffle(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int rowLength = a[i].length;
            for (int j = 0; j < rowLength; j++) {
                int i1 = (int) (Math.random() * a.length);
                int j1 = (int) (Math.random() * rowLength);
                swap(a, i, j, i1, j1);
            }
        }
    }

    private static void swap(int[][] a, int i, int j, int i1, int j1) {
        int temp = a[i][j];
        a[i][j] = a[i1][j1];
        a[i1][j1] = temp;
    }
}
