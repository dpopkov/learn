package learn.ptddjp.stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagerTest {
    private static final Book OF_MICE_AND_MEN = new Book("0140177396", "Of Mice And Men", "J. Steinbeck");
    private static final String ISBN = OF_MICE_AND_MEN.getIsbn();

    private ExternalIsbnDataService dbService;
    private ExternalIsbnDataService webService;
    private StockManager manager;

    @Before
    public void setup() {
        dbService = mock(ExternalIsbnDataService.class);
        webService = mock(ExternalIsbnDataService.class);
        manager = new StockManager(dbService, webService);
    }

    @Test
    public void testCanGetACorrectLocatorCode() {
        when(dbService.lookup(anyString())).thenReturn(null);
        when(webService.lookup(anyString())).thenReturn(OF_MICE_AND_MEN);
        String code = manager.getLocatorCode(OF_MICE_AND_MEN.getIsbn());
        assertEquals("7396J4", code);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        when(dbService.lookup(ISBN)).thenReturn(OF_MICE_AND_MEN);
        manager.getLocatorCode(ISBN);
        verify(dbService).lookup(ISBN);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        when(dbService.lookup(ISBN)).thenReturn(null);
        when(webService.lookup(ISBN)).thenReturn(OF_MICE_AND_MEN);
        manager.getLocatorCode(ISBN);
        verify(dbService).lookup(ISBN);
        verify(webService).lookup(ISBN);
    }
}
