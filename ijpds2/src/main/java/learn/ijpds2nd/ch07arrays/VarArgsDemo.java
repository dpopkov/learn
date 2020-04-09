package learn.ijpds2nd.ch07arrays;

/* Listing 7.5 */
public class VarArgsDemo {
    public static void main(String[] args) {
        printMax(34, 3, 3, 2, 56.5);
        double[] numbers = {1, 2, 3};
        printMax(numbers);
    }

    private static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No arguments passed");
            return;
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}
