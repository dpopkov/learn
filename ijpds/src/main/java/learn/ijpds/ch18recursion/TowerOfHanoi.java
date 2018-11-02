/* 18.8 */
package learn.ijpds.ch18recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = in.nextInt();
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
    }

    private static void moveDisks(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + from + " to " + to);
        } else {
            moveDisks(n - 1, from, aux, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            moveDisks(n - 1, aux, to, from);
        }
    }
}
