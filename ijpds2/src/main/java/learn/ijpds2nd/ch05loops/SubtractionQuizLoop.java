package learn.ijpds2nd.ch05loops;

import learn.ijpds2nd.tools.StopWatch;

import java.util.Scanner;

public class SubtractionQuizLoop {
    public static void main(String[] args) {
        final int NUMBER_OF_QUESTIONS = 5;
        int correctCount = 0;
        int count = 0;
        StringBuilder output = new StringBuilder(" ");
        Scanner in = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        while (count < NUMBER_OF_QUESTIONS) {
            Operands ops = Operands.generate();
            System.out.print("What is " + ops.n1 + " - " + ops.n2 + "? ");
            int answer = in.nextInt();
            boolean correct = ops.produce(answer);
            if (correct) {
                System.out.println("You are correct!");
                correctCount++;
            } else {
                System.out.println("Your answer is wrong.\n" + ops.n1 + " - " + ops.n2 + " should be " + ops.answer());
            }
            count++;
            output.append("\n").append(ops).append(answer).append(correct ? " correct" : " wrong");
        }
        long testTime = stopWatch.stop();
        System.out.println("Correct count is " + correctCount);
        System.out.println("Test time is " + (testTime / 1000) + " seconds");
        System.out.println(output);
    }

    private static class Operands {
        private final int n1;
        private final int n2;

        private Operands(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        private static Operands generate() {
            int v1 = (int) (Math.random() * 10);
            int v2 = (int) (Math.random() * 10);
            if (v1 < v2) {
                int temp = v1;
                v1 = v2;
                v2 = temp;
            }
            return new Operands(v1, v2);
        }

        public boolean produce(int result) {
            return answer() == result;
        }

        public int answer() {
            return n1 - n2;
        }

        @Override
        public String toString() {
            return n1 + " - " + n2 + " = ";
        }
    }
}
