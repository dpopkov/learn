package learn.ptddjp.stock;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockManagerTest {
    @Test
    public void testCanGetACorrectLocatorCode() {
        String isbn = "0140177396";
        StockManager manager = new StockManager();
        ExternalIsbnDataService dbService = i -> null;
        ExternalIsbnDataService webService = i -> new Book("0140177396", "Of Mice And Men", "J. Steinbeck");
        manager.setDbService(dbService);
        manager.setWebService(webService);
        String code = manager.getLocatorCode(isbn);
        assertEquals("7396J4", code);
    }
}
