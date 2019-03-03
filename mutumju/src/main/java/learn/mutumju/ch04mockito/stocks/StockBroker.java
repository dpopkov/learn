package learn.mutumju.ch04mockito.stocks;

import learn.mutumju.ch04mockito.stocks.dto.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockBroker {
    private final static BigDecimal LIMIT = new BigDecimal("0.10");

    private final MarketWatcher market;

    public StockBroker(MarketWatcher market) {
        this.market = market;
    }

    public void perform(Portfolio portfolio, Stock stock) {
        Stock liveStock = market.getQuote(stock.getSymbol());
        BigDecimal avgPrice = portfolio.getAvgPrice(stock);
        BigDecimal priceGained = liveStock.getPrice().subtract(avgPrice);
        BigDecimal percentGain = priceGained.divide(avgPrice, RoundingMode.HALF_UP);
        if (percentGain.compareTo(LIMIT) > 0) {
            portfolio.sell(stock, 10);
        } else if (percentGain.compareTo(LIMIT) < 0) {
            portfolio.buy(stock);
        }
    }
}
