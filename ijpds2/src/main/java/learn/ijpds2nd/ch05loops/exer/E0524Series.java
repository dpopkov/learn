package learn.ijpds2nd.ch05loops.exer;

public class E0524Series {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 97; i++) {
            sum += i / (i + 2.0);
        }
        System.out.println("sum = " + sum);
    }
}
