package introtdd.ch02testing;

/**
 * A coffee shop that can brew coffee and maintains an interval stock of beans and milk.
 */
public class Cafe {
    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew(CoffeeType type) {
        return brew(type, 1);
    }

    private Coffee brew(CoffeeType type, int quantify) {
        requirePositive(quantify);
        int requiredBeans = type.getRequiredBeans() * quantify;
        int requiredMilk = type.getRequiredMilk() * quantify;
        if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
            throw new IllegalArgumentException("Insufficient beans or milk");
        }
        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;
        return new Coffee(type, requiredBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams) {
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    private void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock() {
        return beansInStock;
    }

    public int getMilkInStock() {
        return milkInStock;
    }
}
