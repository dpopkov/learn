package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

public class E010329Checkerboard {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter size of board");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + j) % 2 == 0 ? "*" : " ");
            }
            System.out.println();
        }
    }
}
