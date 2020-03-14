package learn.ijpds2nd.ch05loops.exer;

public class E0510DivBy3And4 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.printf("%4d", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
