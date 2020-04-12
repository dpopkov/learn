package learn.ijpds2nd.ch07arrays.exer;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.IntPredicate;

public class E0701Grades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = in.nextInt();
        int[] scores = new int[n];
        System.out.printf("Enter %d scores: ", n);
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }
        int best = findMaxValue(scores);
        Grader grader = createGrader(best);
        for (int i = 0; i < scores.length; i++) {
            Grade grade = grader.calculate(scores[i]);
            System.out.printf("Student %d score is %d and grade is %s%n", i, scores[i], grade);
        }
    }

    private static Grader createGrader(int best) {
        SortedMap<GradeRule, Grade> rules = new TreeMap<>();
        RuleFactory factory = new RuleFactory(best);
        rules.put(factory.from(5), Grade.A);
        rules.put(factory.from(10), Grade.B);
        rules.put(factory.from(15), Grade.C);
        rules.put(factory.from(20), Grade.D);
        rules.put(factory.from(best), Grade.F);
        return new Grader(rules);
    }

    private enum Grade {A, B, C, D, F}

    private static class RuleFactory {
        private final int best;

        private RuleFactory(int best) {
            this.best = best;
        }

        public GradeRule from(int topBoundary) {
            return new GradeRule(best, topBoundary);
        }
    }

    private static class GradeRule implements IntPredicate, Comparable<GradeRule> {
        private final int boundary;

        private GradeRule(int best, int topBoundary) {
            boundary = best - topBoundary;
        }

        @Override
        public boolean test(int score) {
            return score >= boundary;
        }

        @Override
        public int compareTo(GradeRule o) {
            return Integer.compare(o.boundary, boundary);
        }
    }

    private static class Grader {
        private final SortedMap<GradeRule, Grade> rules;

        private Grader(SortedMap<GradeRule, Grade> rules) {
            this.rules = rules;
        }

        public Grade calculate(int score) {
            for (Map.Entry<GradeRule, Grade> e : rules.entrySet()) {
                if (e.getKey().test(score)) {
                    return e.getValue();
                }
            }
            throw new IllegalStateException("No one rule worked for this score: " + score);
        }
    }

    private static int findMaxValue(int[] scores) {
        int m = -1;
        for (int s : scores) {
            if (s > m) {
                m = s;
            }
        }
        return m;
    }
}
