package learn.ijpds2nd.ch01intro;

public class ShowRuntimeErrors {
    public static void main(String[] args) {
        int divisor = Math.random() < 0.9999999 ? 0 : 1;
        System.out.println(1 / divisor);
    }
}
