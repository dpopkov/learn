package learn.ijpds2nd.ch05loops.exer;

import learn.ijpds2nd.tools.StopWatch;

import java.util.Scanner;

/** Generates 10 random multiplication questions. */
public class E0502Multiplication {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int NUM_GENERATIONS = 10;
        int totalCorrect = 0;
        int total = 0;
        StopWatch stopWatch = new StopWatch();
        for (int i = 1; i <= NUM_GENERATIONS; i++) {
            Expression exp = Expression.generate(Expression.Operation.MULTIPLY, 13);
            System.out.printf("How much is %d * %d? ", exp.o1(), exp.o2());
            int answer = in.nextInt();
            if (exp.isProducing(answer)) {
                System.out.println("You are correct");
                totalCorrect++;
            } else {
                System.out.printf("Wrong answer. %d * %d is %d%n", exp.o1(), exp.o2(), exp.result());
            }
            total++;
        }
        long elapsed = stopWatch.stop();
        System.out.printf("You gave %d correct answers out of %d for %d seconds%n", totalCorrect, total, elapsed / 1000);
    }
}
