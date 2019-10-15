package learn.dsajg6e.ch09pq2.exer.c0948trading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private static final Pattern pattern = Pattern.compile("(buy|sell)\\s+(\\d+)\\s+shares\\s+at\\s+\\$(\\d+) each");

    enum Type {
        BUY,
        SELL
    }
    private Type type;
    private int numShares;
    private int price;
    private boolean processed;

    public Order(Type type, int numShares, int price) {
        this.type = type;
        this.numShares = numShares;
        this.price = price;
    }

    public Order(String order) {
        parseString(order);
    }

    private void parseString(String order) {
        Matcher matcher = pattern.matcher(order);
        if (matcher.matches()) {
            String typeStr = matcher.group(1);
            type = Type.valueOf(typeStr.toUpperCase());
            try {
                numShares = Integer.parseInt(matcher.group(2));
                price = Integer.parseInt(matcher.group(3));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid order format: " + order, e);
            }
        } else {
            throw new IllegalArgumentException("Invalid order format: " + order);
        }
    }

    public Type getType() {
        return type;
    }

    public int getNumShares() {
        return numShares;
    }

    public int getPrice() {
        return price;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    static Order buy(int shares, int price) {
        return new Order(Type.BUY, shares, price);
    }

    static Order sell(int shares, int price) {
        return new Order(Type.SELL, shares, price);
    }
}
