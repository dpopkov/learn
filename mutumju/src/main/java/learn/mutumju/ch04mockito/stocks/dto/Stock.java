package learn.mutumju.ch04mockito.stocks.dto;

import java.math.BigDecimal;

public class Stock {
    public static final Stock EMPTY = new Stock(null, null, null);

    private final String symbol;
    private final String name;
    private BigDecimal price;

    public Stock(String symbol, String name, BigDecimal price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void updatePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }
}
