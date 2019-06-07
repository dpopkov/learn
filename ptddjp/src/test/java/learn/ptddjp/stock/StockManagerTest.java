package learn.ptddjp.stock;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockManagerTest {
    @Test
    public void testCanGetACorrectLocatorCode() {
        String isbn = "0140177396";
        StockManager manager = new StockManager();
        manager.setService(i -> new Book("0140177396", "Of Mice And Men", "J. Steinbeck"));
        String code = manager.getLocatorCode(isbn);
        assertEquals("7396J4", code);
    }
}
