package learn.ijpds2nd.ch05loops.exer;

public class E0507Tuition {
    public static void main(String[] args) {
        double tuition = 10_000.0;
        double yearlyPercent = 1.06;
        System.out.println("Year  Tuition");
        for (int year = 1; year <= 10; year++) {
            tuition *= yearlyPercent;
            System.out.printf("%4d  %5.1f%n", year, tuition);
        }
        double fourYearsAfter10 = 0;
        for (int year = 10; year <= 14; year++) {
            tuition *= yearlyPercent;
            fourYearsAfter10 += tuition;
        }
        System.out.printf("Total cost of 4 years after the 10th year: %5.1f%n", fourYearsAfter10);
    }
}
