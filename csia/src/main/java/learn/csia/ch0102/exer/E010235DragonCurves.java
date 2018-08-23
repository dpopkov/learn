package learn.csia.ch0102.exer;

import java.util.Scanner;

/**
 1.2.35 Dragon curves. Write a program to print the instructions for drawing the
 dragon curves of order 0 through 5. The instructions are strings of F, L, and R
 characters, where F means “draw line while moving 1 unit
 forward,” L means “turn left,” and R means “turn right.” A
 dragon curve of order n is formed when you fold a strip
 of paper in half n times, then unfold to right angles. The
 key to solving this problem is to note that a curve of order
 n is a curve of order n1 followed by an L followed by a
 curve of order n1 traversed in reverse order, and then
 to fgure out a similar description for the reverse curve.

 Dragon curves of order 0, 1, 2, and 3:
 0: F
 1: FLF
 2: FLFLFRF
 3: FLFLFRFLFLFRFRF
 */
public class E010235DragonCurves {
    public static void main(String[] args) {
        int order;
        if (args.length >= 1) {
            order = Integer.parseInt(args[0]);
        } else {
            Scanner in = new Scanner(System.in);
            order = in.nextInt();
        }
        System.out.println(buildDragonCurves(order));
    }

    public static String buildDragonCurves(int order) {
        if (order == 0) {
            return "F";
        } else if (order == 1) {
            return "FLF";
        } else {
            String left = buildDragonCurves(order - 1);
            int mid = left.length() / 2;
            String initialRotate = left.substring(mid, mid + 1);
            String nextRotate = "R".equals(initialRotate) ? "L" : "R";
            String right = left.substring(0, mid) + nextRotate + left.substring(mid + 1);
            return left + "L" + right;
        }
    }
}
