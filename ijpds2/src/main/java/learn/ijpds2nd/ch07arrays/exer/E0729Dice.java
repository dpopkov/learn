package learn.ijpds2nd.ch07arrays.exer;

/*
Suppose three dice are thrown at random. Write a program that shows
all possible permutations or configurations of the three dice
that yield the sum of nine.
 */
public class E0729Dice {
    public static void main(String[] args) {
        for (int d1 = 1; d1 <= 6; d1++) {
            for (int d2 = 1; d2 <= 6; d2++) {
                for (int d3 = 1; d3 <= 6; d3++) {
                    int sum = d1 + d2 + d3;
                    if (sum == 9) {
                        System.out.printf("%d + %d + %d = %d%n", d1, d2, d3, sum);
                    }
                }
            }
        }
    }
}
