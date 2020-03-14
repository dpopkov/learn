package learn.ijpds2nd.ch05loops.exer;

public class E0515AsciiTable {
    public static void main(String[] args) {
        int i = 0;
        for (char ch = '!'; ch <= '~'; ch++) {
            System.out.print(ch);
            System.out.print(' ');
            i++;
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
