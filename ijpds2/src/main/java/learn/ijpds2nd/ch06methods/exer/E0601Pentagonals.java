package learn.ijpds2nd.ch06methods.exer;

public class E0601Pentagonals {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%7d", getPentagonalNumber(i));
            System.out.print(i % 7 == 0 ? '\n' : ' ');
        }
    }

    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }
}
