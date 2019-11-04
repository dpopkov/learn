package learn.dsajg6e.ch10maps.exer;

public class C1049FindKthSmallestKey<E extends Comparable<E>> {
    @SuppressWarnings("unchecked")
    public E findKthSmallestKey(E[] s, E[] t, int k) {
        int totalLength = s.length + t.length;
        E[] merged = (E[]) new Comparable[totalLength];
        int i = 0;
        int si = 0;
        int ti = 0;
        for (; si < s.length && ti < t.length && i < totalLength; i++) {
            int cmp = s[si].compareTo(t[ti]);
            if (cmp < 0) {
                merged[i] = s[si++];
            } else {
                merged[i] = t[ti++];
            }
            if (i == k) {
                return merged[k];
            }
        }
        for (; si < s.length && i < totalLength; si++, i++) {
            merged[i] = s[si];
            if (i == k) {
                return merged[k];
            }
        }
        for (; ti < t.length && i < totalLength; ti++, i++) {
            merged[i] = t[ti];
            if (i == k) {
                return merged[k];
            }
        }
        return merged[k];
    }
}
