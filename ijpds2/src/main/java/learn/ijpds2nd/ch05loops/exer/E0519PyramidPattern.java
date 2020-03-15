package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0519PyramidPattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number and height of the pyramid: ");
        int number = in.nextInt();
        int height = in.nextInt();
        PowerPyramid pyramid = new PowerPyramid(6, number);
        System.out.println(pyramid.build(height));
    }
}
