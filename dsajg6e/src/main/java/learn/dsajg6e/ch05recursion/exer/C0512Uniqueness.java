package learn.dsajg6e.ch05recursion.exer;

/*
Describe an efficient recursive algorithm for solving the element uniqueness
problem, which runs in time that is at most O(n^2) in the worst case
without using sorting
 */
public class C0512Uniqueness {
    public static boolean unique(int[] a) {
        return uniqueIn(0, a);
    }

    private static boolean uniqueIn(int idx, int[] a) {
        if (idx >= a.length) {
            return true;
        }
        if (!isAbsent(idx, a, idx + 1)) {
            return false;
        }
        return uniqueIn(idx + 1, a);
    }

    private static boolean isAbsent(int idx, int[] a, int from) {
        if (from >= a.length) {
            return true;
        } else if (a[idx] == a[from]) {
            return false;
        }
        return isAbsent(idx, a, from + 1);
    }
}
