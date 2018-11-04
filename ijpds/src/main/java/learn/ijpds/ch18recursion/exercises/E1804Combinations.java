/*
18.4
Combinations refer to the combination of n things taken p at a time without
repetition. A recursive definition of C(n, p) is C(n, 0) = C(n, n) = 1, otherwise
C(n, p) = C(n- 1, p) + C(n- 1, p-1).
 */
package learn.ijpds.ch18recursion.exercises;

public class E1804Combinations {
    public static int combinations(int n, int p) {
        if (n == p || p == 0) {
            return 1;
        }
        return combinations(n - 1, p) + combinations(n - 1, p - 1);
    }
}
