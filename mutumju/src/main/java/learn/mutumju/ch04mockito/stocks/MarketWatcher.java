package learn.mutumju.ch04mockito.stocks;

import learn.mutumju.ch04mockito.stocks.dto.Stock;

public interface MarketWatcher {
    /**
     * Looks up the stock market and returns the quote for the stock.
     */
    Stock getQuote(String symbol);
}
