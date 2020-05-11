package learn.ijpds2nd.ch08multiarrays.exer;

public class E0823FindFlippedCell {
    static int[] findFlippedCell(int[][] m) {
        int rowIdx = -1;
        for (int r = 0; r < m.length; r++) {
            int total = 0;
            for (int v : m[r]) {
                total += v;
            }
            if (total % 2 == 1) {
                rowIdx = r;
            }
        }
        int colIdx = -1;
        for (int c = 0; c < m[0].length; c++) {
            int total = 0;
            for (int[] row : m) {
                total += row[c];
            }
            if (total % 2 == 1) {
                colIdx = c;
                break;
            }
        }
        return new int[] {rowIdx, colIdx};
    }
}
