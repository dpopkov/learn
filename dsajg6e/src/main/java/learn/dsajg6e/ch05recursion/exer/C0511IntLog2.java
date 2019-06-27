package learn.dsajg6e.ch05recursion.exer;

/*
Describe a recursive algorithm to compute the integer part of the base-two
logarithm of n using only addition and integer division.
 */
public class C0511IntLog2 {
    public static int log2Rec(int x) {
        if (x < 2) {
            return 0;
        }
        return log2Rec(x / 2) + 1;
    }

    public static int log2NonRec(int x) {
        int rst = 0;
        while (x >= 2) {
            x = x / 2;
            rst++;
        }
        return rst;
    }
}
