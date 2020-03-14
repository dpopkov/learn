package learn.ijpds2nd.ch05loops.exer;

public class E0513LargestLess {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        final double target = 12_000.0;
        int n = (int) Math.sqrt(target);
        if (n * n == target) {
            n--;
        }
        System.out.println("n = " + n);
        System.out.println("n * n = " + n * n);
        n++;
        System.out.println("Next n:");
        System.out.println("n * n = " + n * n);
    }
}
