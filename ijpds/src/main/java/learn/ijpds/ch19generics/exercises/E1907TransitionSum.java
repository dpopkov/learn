package learn.ijpds.ch19generics.exercises;

public class E1907TransitionSum {
    static double sumTransition(E1906Transition<? extends Number, ? extends Number, ? extends Number> t) {
        double sum = 0.0;
        sum += t.getFirst().doubleValue();
        sum += t.getSecond().doubleValue();
        sum += t.getThird().doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        E1906Transition<Integer, Double, Long> t = new E1906Transition<>(42, 12.3, 10000000000L);
        double sum = sumTransition(t);
        System.out.printf("%13.1f", sum);
    }
}
