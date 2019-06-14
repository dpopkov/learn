package learn.dsajg6e.ch03fund.exer;

import java.util.Scanner;

public class C0320PseudoRandom {
    private final int a;
    private final int b;
    private final int n;
    private int current;

    public C0320PseudoRandom(int a, int b, int n, int seed) {
        this.a = a;
        this.b = b;
        this.n = n;
        current = seed;
    }

    public int next() {
        int result = current;
        current = next(current);
        return result;
    }

    private int next(int previous) {
        return (a * previous + b) % n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a and b: ");
        int a = in.nextInt();
        int b = in.nextInt();
        C0320PseudoRandom rnd = new C0320PseudoRandom(a, b, 1000, 1);
        for (int i = 0; i < 20; i++) {
            System.out.println(rnd.next());
        }
    }
}
