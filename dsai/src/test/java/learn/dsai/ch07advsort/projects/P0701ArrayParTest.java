package learn.dsai.ch07advsort.projects;

import learn.dsai.tools.ArrayTools;
import org.junit.Test;

import static org.junit.Assert.*;

public class P0701ArrayParTest {

    @Test
    public void testPartitionIt() {
        P0701ArrayPar arr = new P0701ArrayPar(10);
        long[] values = {9, 2, 0, 6, 5, 8, 1, 4, 6, 7};
        arr.insert(values);
        int p = arr.partitionIt(0, arr.getSize() - 1);
        assertTrue(ArrayTools.isPartitioned(arr.getValues(), p));
    }

    @Test
    public void testPartitionItWhen3Elems() {
        P0701ArrayPar arr = new P0701ArrayPar(3);
        long[] values = {9, 8, 7};
        arr.insert(values);
        int p = arr.partitionIt(0, arr.getSize() - 1);
        assertTrue(ArrayTools.isPartitioned(arr.getValues(), p));
    }

    @Test
    public void testPartitionItWhen2Elems() {
        P0701ArrayPar arr = new P0701ArrayPar(2);
        long[] values = {8, 7};
        arr.insert(values);
        int p = arr.partitionIt(0, arr.getSize() - 1);
        assertTrue(ArrayTools.isPartitioned(arr.getValues(), p));
    }
}
