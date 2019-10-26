package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

/**
 * Maintains a database of maximal (cost, performance) pairs.
 */
public class CostPerformanceDatabase {
    final SortedMap<Integer, Integer> map = new SortedTableMap<>();

    /**
     * Returns the (cost, performance) entry with largest cost not exceeding the specified cost
     * (or null if no entry exists with the specified cost or less).
     */
    public Entry<Integer, Integer> best(int cost) {
        return map.floorEntry(cost);
    }

    /** Adds the new entry with the specified cost and performance. */
    public void add(int cost, int performance) {
        if (hasSameOrLessCostWithSameOrBetterPerformance(cost, performance)) {
            return;
        }
        map.put(cost, performance);
        removeMoreExpensiveWithNotBetterPerformance(cost, performance);
    }

    private boolean hasSameOrLessCostWithSameOrBetterPerformance(int cost, int performance) {
        Entry<Integer, Integer> other = map.floorEntry(cost);
        return  other != null && other.getValue() >= performance;
    }

    private void removeMoreExpensiveWithNotBetterPerformance(int cost, int performance) {
        Entry<Integer, Integer> other = map.higherEntry(cost);
        while (other != null && other.getValue() <= performance) {
            map.remove(other.getKey());
            other = map.higherEntry(cost);
        }
    }
}
