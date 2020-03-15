package learn.ijpds2nd.ch05loops.exer;

import java.io.PrintStream;

public class E0518FourPatterns {
    private static final String STAR = "* ";
    private static final String SPACE = "  ";

    private static class Pattern {
        private final int size;
        private final PrintStream out;

        public Pattern(int size, PrintStream out) {
            this.size = size;
            this.out = out;
        }

        public void bottomLeft() {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c <= r; c++) {
                    out.print(STAR);
                }
                out.println();
            }
        }

        public void topLeft() {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size - r; c++) {
                    out.print(STAR);
                }
                out.println();
            }
        }

        public void bottomRight() {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size - r - 1; c++) {
                    out.print(SPACE);
                }
                for (int c = 0; c <= r; c++) {
                    out.print(STAR);
                }
                out.println();
            }
        }

        public void topRight() {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < r; c++) {
                    out.print(SPACE);
                }
                for (int c = 0; c < size - r; c++) {
                    out.print(STAR);
                }
                out.println();
            }
        }
    }

    public static void main(String[] args) {
        Pattern pattern = new Pattern(6, System.out);
        pattern.bottomLeft();
        pattern.topLeft();
        pattern.bottomRight();
        pattern.topRight();
    }
}
