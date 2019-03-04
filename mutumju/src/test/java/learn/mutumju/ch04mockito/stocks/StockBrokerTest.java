package learn.mutumju.ch04mockito.stocks;

import learn.mutumju.ch04mockito.stocks.dto.Stock;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /** This map is used in {@link #testUsingAnswer()} test. */
    private static final Map<String, List<Stock>> stockMap = new HashMap<>();

    private static class BuyAnswer implements Answer {
        @SuppressWarnings("Duplicates")
        @Override
        public Object answer(InvocationOnMock invocation) {
            Stock newStock = (Stock) invocation.getArguments()[0];
            List<Stock> stocks = stockMap.get(newStock.getSymbol());
            if (stocks != null) {
                stocks.add(newStock);
            } else {
                stocks = new ArrayList<>();
                stocks.add(newStock);
                stockMap.put(newStock.getSymbol(), stocks);
            }
            return null;
        }
    }

    private static class TotalPriceAnswer implements Answer<BigDecimal> {
        @SuppressWarnings("Duplicates")
        @Override
        public BigDecimal answer(InvocationOnMock invocation) {
            BigDecimal total = BigDecimal.ZERO;
            for (String symbol : stockMap.keySet()) {
                for (Stock stock : stockMap.get(symbol)) {
                    total = total.add(stock.getPrice());
                }
            }
            return total;
        }
    }

    @Test
    public void testUsingAnswer() {
        stockMap.clear();
        doAnswer(new BuyAnswer()).when(portfolio).buy(isA(Stock.class));
        when(portfolio.getCurrentValue()).then(new TotalPriceAnswer());

        portfolio.buy(new Stock("A", "A", BigDecimal.TEN));
        portfolio.buy(new Stock("B", "B", BigDecimal.ONE));

        assertEquals(new BigDecimal("11"), portfolio.getCurrentValue());
    }

    @Test
    public void testSpying() {
        Stock realStock = new Stock("A", "Company A", BigDecimal.ONE);
        Stock spyStock = spy(realStock);

        // call real method from spy
        assertEquals("A", spyStock.getSymbol());

        // Changing value using spy
        spyStock.updatePrice(BigDecimal.ZERO);

        // verify spy has the changed value
        assertEquals(BigDecimal.ZERO, spyStock.getPrice());

        // Stubbing method
        when(spyStock.getPrice()).thenReturn(BigDecimal.TEN);

        // Changing value using spy
        spyStock.updatePrice(new BigDecimal("7"));

        assertNotEquals(new BigDecimal("7"), spyStock.getPrice());
        assertEquals(BigDecimal.TEN, spyStock.getPrice());
    }

    @Test(expected = RuntimeException.class)
    public void playWithVoidMethods() {
        Answer dummy = invocation -> {
            System.out.println("Dummy answer");
            return null;
        };
        doAnswer(dummy)     // prints "Dummy answer"
        .doNothing()        // does nothing
        .doAnswer(dummy)    // prints "Dummy answer"
        .doThrow(new RuntimeException()).when(portfolio).buy(Stock.EMPTY);

        portfolio.buy(Stock.EMPTY);
        portfolio.buy(Stock.EMPTY);
        portfolio.buy(Stock.EMPTY);
        portfolio.buy(Stock.EMPTY);
    }

    @Test
    public void testArgumentCaptor() {
        when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(new BigDecimal("10.00"));
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal("11.20"));
        when(marketWatcher.getQuote(anyString())).thenReturn(aCorp);
        broker.perform(portfolio, aCorp);

        ArgumentCaptor<String> stockIdCaptor = ArgumentCaptor.forClass(String.class);

        verify(marketWatcher).getQuote(stockIdCaptor.capture());
        assertThat(stockIdCaptor.getValue(), Is.is("A"));

        // Using two captors
        ArgumentCaptor<Stock> stockCaptor = ArgumentCaptor.forClass(Stock.class);
        ArgumentCaptor<Integer> stockSellCountCaptor = ArgumentCaptor.forClass(Integer.class);

        verify(portfolio).sell(stockCaptor.capture(), stockSellCountCaptor.capture());
        assertThat(stockCaptor.getValue().getSymbol(), Is.is("A"));
        assertThat(stockSellCountCaptor.getValue(), Is.is(10));
    }

    @Test
    public void testInvocationInOrder() {
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal("11.20"));
        portfolio.getAvgPrice(aCorp);
        portfolio.getCurrentValue();
        marketWatcher.getQuote("X");
        portfolio.buy(aCorp);
        InOrder inOrder = inOrder(portfolio, marketWatcher);
        inOrder.verify(portfolio).getAvgPrice(isA(Stock.class));
        inOrder.verify(portfolio).getCurrentValue();
        inOrder.verify(marketWatcher).getQuote(anyString());
        inOrder.verify(portfolio).buy(isA(Stock.class));
    }

    @Test
    public void testChangingDefaults() {
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal("11.20"));
        Portfolio pf0 = Mockito.mock(Portfolio.class);
        // default null is returned
        assertNull(pf0.getAvgPrice(aCorp));

        Portfolio pf1 = Mockito.mock(Portfolio.class, RETURNS_SMART_NULLS);
        System.out.println("#1 " + pf1.getAvgPrice(aCorp));
        assertNotNull(pf1.getAvgPrice(aCorp));

        Portfolio pf2 = Mockito.mock(Portfolio.class, RETURNS_MOCKS);
        System.out.println("#2 " + pf2.getAvgPrice(aCorp));
        assertNotNull(pf2.getAvgPrice(aCorp));

        Portfolio pf3 = Mockito.mock(Portfolio.class, RETURNS_DEEP_STUBS);
        System.out.println("#3 " + pf3.getAvgPrice(aCorp));
        assertNotNull(pf3.getAvgPrice(aCorp));
    }

    @Test
    public void testResetMock() {
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal(11.20));
        Portfolio portfolio = Mockito.mock(Portfolio.class);
        when(portfolio.getAvgPrice(eq(aCorp))).thenReturn(BigDecimal.ONE);
        BigDecimal price = portfolio.getAvgPrice(aCorp);
        assertNotNull(price);
        assertThat(price, Is.is(BigDecimal.ONE));

        //Resets the stub, so getAvgPrice returns NULL
        Mockito.reset(portfolio);
        assertNull(portfolio.getAvgPrice(aCorp));
    }

    /** Example if inline stubbing (create mocks while stubbing it). */
    final Stock globalStock = when(Mockito.mock(Stock.class).getPrice()).thenReturn(BigDecimal.ONE).getMock();

    @Test
    public void testAccessingGlobalMock() {
        assertEquals(BigDecimal.ONE, globalStock.getPrice());
    }

    @Test
    public void testGettingMockingDetails() {
        Portfolio pf1 = Mockito.mock(Portfolio.class, Mockito.RETURNS_MOCKS);
        BigDecimal result = pf1.getAvgPrice(globalStock);
        assertNotNull(result);
        assertTrue(Mockito.mockingDetails(pf1).isMock());

        Stock myStock = new Stock(null, null, null);
        Stock spy = spy(myStock);
        assertTrue(Mockito.mockingDetails(spy).isSpy());
    }
}
