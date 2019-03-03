package learn.mutumju.ch04mockito.stocks;

import org.mockito.ArgumentMatcher;

public class BlueChipStockMatcher implements ArgumentMatcher<String> {
    @Override
    public boolean matches(String symbol) {
        return "FB".equals(symbol) || "AAPL".equals(symbol);
    }
}
