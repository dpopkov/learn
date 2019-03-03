package learn.mutumju.ch04mockito.stocks;

import learn.mutumju.ch04mockito.stocks.dto.Stock;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockBrokerTest {
    @Mock
    MarketWatcher marketWatcher;
    @Mock
    Portfolio portfolio;
    StockBroker broker;

    @Before
    public void setup() {
        broker = new StockBroker(marketWatcher);
    }

    @Test
    public void sanity() {
        assertNotNull(marketWatcher);
        assertNotNull(portfolio);
    }

    @Test
    public void marketWatcherReturnsCurrentStockStatus() {
        Stock uvsityCorp = new Stock("UV", "Uvsity Corporations", new BigDecimal("100.00"));
        when(marketWatcher.getQuote(anyString())).thenReturn(uvsityCorp);
        Stock quote = marketWatcher.getQuote("UV");
        assertNotNull(quote);
        assertThat(quote.getSymbol(), Is.is("UV"));
        assertThat(quote.getPrice(), Is.is(new BigDecimal("100.00")));
    }

    @Test
    public void whenTenPercentGainThenTheStockIsSold() {
        when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(new BigDecimal("10.00"));
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal("11.20"));
        when(marketWatcher.getQuote(anyString())).thenReturn(aCorp);
        broker.perform(portfolio, aCorp);
        verify(portfolio).sell(aCorp, 10);
        verify(portfolio, never()).buy(aCorp);
    }

    @Test
    public void testVerifyZeroInteractions() {
        verifyZeroInteractions(marketWatcher, portfolio);
    }

    @Ignore("This test must fail because it demonstrates verifyNoMoreInteractions")
    @SuppressWarnings("ConstantConditions")
    @Test
    public void testVerifyNoMoreInteraction() {
        Stock noStock = null;
        portfolio.getAvgPrice(noStock);
        portfolio.sell(null, 0);
        verify(portfolio).getAvgPrice(eq(noStock));
        verifyNoMoreInteractions(portfolio);
    }

    /** Example of the {@code ArgumentMatcher} usage. */
    @Test
    public void testArgumentMatcher() {
        when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(new BigDecimal("10.00"));
        Stock blueChipStock = new Stock("FB", "FB Corp", new BigDecimal("1000.00"));
//        Stock otherStock = new Stock("XY", "XY Corp", new BigDecimal("5.00"));
        when(marketWatcher.getQuote(argThat(new BlueChipStockMatcher()))).thenReturn(blueChipStock);
//        when(marketWatcher.getQuote(argThat(new OtherStockMatcher()))).thenReturn(otherStock);
        broker.perform(portfolio, blueChipStock);
        verify(portfolio).sell(blueChipStock, 10);
    }

    @Test(expected = IllegalStateException.class)
    public void throwsException() {
        when(portfolio.getAvgPrice(isA(Stock.class))).thenThrow(new IllegalStateException("Database down"));
        portfolio.getAvgPrice(new Stock(null, null, null));
    }

    @Test(expected = IllegalStateException.class)
    public void throwsExceptionVoidMethods() {
        doThrow(new IllegalStateException()).when(portfolio).buy(isA(Stock.class));
        portfolio.buy(new Stock(null, null, null));
    }

    @Test
    public void testConsecutiveCalls() {
        Stock stock = new Stock(null, null, null);
        when(portfolio.getAvgPrice(stock)).thenReturn(BigDecimal.TEN, BigDecimal.ZERO);
        assertEquals(BigDecimal.TEN, portfolio.getAvgPrice(stock));
        assertEquals(BigDecimal.ZERO, portfolio.getAvgPrice(stock));
        assertEquals(BigDecimal.ZERO, portfolio.getAvgPrice(stock));
        assertEquals(BigDecimal.ZERO, portfolio.getAvgPrice(stock));
    }
}
