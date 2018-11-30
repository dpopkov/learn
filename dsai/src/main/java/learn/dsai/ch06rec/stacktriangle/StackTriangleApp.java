package learn.dsai.ch06rec.stacktriangle;

import learn.dsai.ch06rec.StackT;

import java.util.Scanner;

public class StackTriangleApp {
    private static int theNumber;
    private static int theAnswer;
    private static StackT<Params> stack;
    private static int codePart;
    private static Params params;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        theNumber = in.nextInt();
        recTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    private static void recTriangle() {
        stack = new StackT<>(10_000);
        codePart = 1;
        boolean done = false;
        while (!done) {
            done = step();
        }
    }

    private static boolean step() {
        switch (codePart) {
            case 1:                         // initial call
                params = new Params(theNumber, 6);
                stack.push(params);
                codePart = 2;
                break;
            case 2:                         // method entry
                params = stack.peek();
                if (params.number == 1) {
                    theAnswer = 1;
                    codePart = 5;           // exit
                } else {
                    codePart = 3;           // recursive call
                }
                break;
            case 3:                         // method call
                Params newParams = new Params(params.number - 1, 4);
                stack.push(newParams);
                codePart = 2;               // go enter method
                break;
            case 4:                         // calculation
                params = stack.peek();
                theAnswer = theAnswer + params.number;
                codePart = 5;
                break;
            case 5:                         // method exit
                params = stack.peek();
                codePart = params.returnAddress;    // (4 or 6)
                stack.pop();
                break;
            case 6:                         // return point
                return true;
        }
        return false;
    } // end method step()
}
