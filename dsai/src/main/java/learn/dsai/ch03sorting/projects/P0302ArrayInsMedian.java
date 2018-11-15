package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayIns;

public class P0302ArrayInsMedian extends ArrayIns {

    public P0302ArrayInsMedian(int max) {
        super(max);
    }

    /**
     * @return the median value in the array.
     */
    public long median() {
        ArrayIns copiedValues = new ArrayIns(this.nElems);
        copyTo(copiedValues);
        copiedValues.sort();
        int middleIndex = copiedValues.getSize() / 2;
        return copiedValues.get(middleIndex);
    }

    public static void main(String[] args) {
        P0302ArrayInsMedian arr = new P0302ArrayInsMedian(5);
        arr.insert(1);
        arr.insert(1);
        arr.insert(10);
        arr.insert(100);
        arr.insert(2);
        System.out.println("Median: " + arr.median());
    }
}
