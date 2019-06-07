package learn.ptddjp.stock;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagerTest {

    private static final Book OF_MICE_AND_MEN = new Book("0140177396", "Of Mice And Men", "J. Steinbeck");

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
        StockManager manager = new StockManager();
        ExternalIsbnDataService dbService = mock(ExternalIsbnDataService.class);
        ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);
        String isbn = OF_MICE_AND_MEN.getIsbn();
        when(dbService.lookup(isbn)).thenReturn(OF_MICE_AND_MEN);
        manager.setDbService(dbService);
        manager.setWebService(webService);

        manager.getLocatorCode(isbn);
        verify(dbService).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        StockManager manager = new StockManager();
        ExternalIsbnDataService dbService = mock(ExternalIsbnDataService.class);
        ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);
        String isbn = OF_MICE_AND_MEN.getIsbn();
        when(dbService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(OF_MICE_AND_MEN);
        manager.setDbService(dbService);
        manager.setWebService(webService);

        manager.getLocatorCode(isbn);
        verify(dbService).lookup(isbn);
        verify(webService).lookup(isbn);
    }
}
