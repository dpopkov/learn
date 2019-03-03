package learn.mutumju.ch04mockito.stocks;

public class OtherStockMatcher extends BlueChipStockMatcher {
    @Override
    public boolean matches(String symbol) {
        return !super.matches(symbol);
    }
}
