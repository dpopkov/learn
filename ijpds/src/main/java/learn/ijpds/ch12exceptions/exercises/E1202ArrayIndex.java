package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

public class E1202ArrayIndex {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        CliAppArgs in = new CliAppArgs(args, "Enter number between 1 and 12");
        int n = in.nextInt();
        try {
            String month = months[n - 1];
            int days = dom[n - 1];
            System.out.printf("There are %d days in %s%n", days, month);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number " + n);
        }
    }
}
