package learn.dsai.ch07advsort;

import learn.dsai.tools.ArrayTools;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayParTest {

    @Test
    public void testPartitionIt() {
        ArrayPar arr = new ArrayPar(10);
        arr.insert(new long[] {6, 7, 8, 9, 5, 4, 3, 2, 1, 0});
        int p = arr.partitionIt(0, arr.getSize() - 1, 5);
        assertTrue(ArrayTools.isPartitioned(arr.getValues(), p));
    }

    @Test
    public void testPartitionItWhenPivotIsMinimum() {
        ArrayPar arr = new ArrayPar(10);
        arr.insert(new long[] {6, 7, 8, 9, 5, 4, 3, 2, 1, 0});
        int p = arr.partitionIt(0, arr.getSize() - 1, 0);
        assertTrue(ArrayTools.isPartitioned(arr.getValues(), p));
    }
}
