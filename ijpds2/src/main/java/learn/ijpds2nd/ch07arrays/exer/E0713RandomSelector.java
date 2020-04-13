package learn.ijpds2nd.ch07arrays.exer;

public class E0713RandomSelector {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int i = getRandom(a);
        System.out.println("Random number: " + i);
    }

    private static int getRandom(int[] a) {
        int idx = (int) (Math.random() * a.length);
        return a[idx];
    }
}
