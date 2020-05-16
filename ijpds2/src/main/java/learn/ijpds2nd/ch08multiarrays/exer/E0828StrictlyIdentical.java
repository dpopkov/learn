package learn.ijpds2nd.ch08multiarrays.exer;

public class E0828StrictlyIdentical {
    static boolean equals(int[][] m1, int[][] m2) {
        int height = m1.length;
        if (height != m2.length) {
            return false;
        }
        int width = m1[0].length;
        if (width != m2[0].length) {
            return false;
        }
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (m1[r][c] != m2[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
