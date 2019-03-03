package learn.mutumju.ch04mockito.stocks;

import learn.mutumju.ch04mockito.stocks.dto.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private final Map<String, List<Stock>> stockMap = new HashMap<>();

    public void buy(Stock stock) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if(stocks != null) {
            stocks.add(stock);
        }else {
            stocks = new ArrayList<>();
            stocks.add(stock);
            stockMap.put(stock.getSymbol(), stocks);
        }
    }

    public void sell(Stock stock, int quantity) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if(stocks == null) {
            throw new IllegalStateException(stock.getSymbol() + " not bought");
        }
        if(stocks.size() < quantity) {
            quantity = stocks.size();
        }
        if (quantity > 0) {
            stocks.subList(0, quantity).clear();
        }
    }

    public BigDecimal getAvgPrice(Stock stock) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        BigDecimal avgPrice = BigDecimal.ZERO;
        if(stocks != null) {
            for(Stock aStock : stocks) {
                avgPrice = avgPrice.add(aStock.getPrice());
            }
            avgPrice = avgPrice.divide(new BigDecimal(stocks.size()), RoundingMode.HALF_UP);
        }
        return avgPrice;
    }

    public BigDecimal getCurrentValue() {
        BigDecimal avgPrice = BigDecimal.ZERO;
        for(String stockId : stockMap.keySet()) {
            for(Stock stock : stockMap.get(stockId)) {
                avgPrice = avgPrice.add(stock.getPrice());
            }
        }
        return avgPrice;
    }
}

