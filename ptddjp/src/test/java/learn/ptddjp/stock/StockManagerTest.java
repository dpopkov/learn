package learn.ptddjp.stock;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagerTest {

    private static final Book OF_MICE_AND_MEN = new Book("0140177396", "Of Mice And Men", "J. Steinbeck");
    private static final String ISBN = OF_MICE_AND_MEN.getIsbn();

    @Test
    public void testCanGetACorrectLocatorCode() {
        StockManager manager = new StockManager();
        ExternalIsbnDataService dbService = i -> null;
        ExternalIsbnDataService webService = i -> OF_MICE_AND_MEN;
        manager.setDbService(dbService);
        manager.setWebService(webService);
        String code = manager.getLocatorCode(OF_MICE_AND_MEN.getIsbn());
        assertEquals("7396J4", code);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        var dbService = mock(ExternalIsbnDataService.class);
        var webService = mock(ExternalIsbnDataService.class);
        when(dbService.lookup(ISBN)).thenReturn(OF_MICE_AND_MEN);
        StockManager manager = new StockManager(dbService, webService);

        manager.getLocatorCode(ISBN);
        verify(dbService).lookup(ISBN);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        var dbService = mock(ExternalIsbnDataService.class);
        var webService = mock(ExternalIsbnDataService.class);
        when(dbService.lookup(ISBN)).thenReturn(null);
        when(webService.lookup(ISBN)).thenReturn(OF_MICE_AND_MEN);
        StockManager manager = new StockManager(dbService, webService);

        manager.getLocatorCode(ISBN);
        verify(dbService).lookup(ISBN);
        verify(webService).lookup(ISBN);
    }
}
