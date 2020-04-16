package learn.ijpds2nd.ch07arrays.exer;

public class E0723LockerPuzzle {

    public static final int NUM = 100;

    public static void main(String[] args) {
        boolean[] lockers = new boolean[NUM];
        for (int student = 0; student < NUM; student++) {
            int step = student + 1;
            for (int i = student; i < lockers.length; i += step) {
                lockers[i] = !lockers[i];
            }
        }
        System.out.println("Open lockers:");
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
